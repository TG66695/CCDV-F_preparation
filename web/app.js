const EXAM_DURATION_SECONDS = 120 * 60;
const LOW_TIME_WARNING_SECONDS = 5 * 60;
const PASS_RATIO = 0.72;
const EXAM_QUESTION_COUNT = 53;
const GENERATED_QUESTIONS_KEY = "generatedQuestions";

const startScreen = document.getElementById("start-screen");
const quizScreen = document.getElementById("quiz-screen");
const resultScreen = document.getElementById("result-screen");

const startBtn = document.getElementById("start-btn");
const nextBtn = document.getElementById("next-btn");
const finishBtn = document.getElementById("finish-btn");
const restartBtn = document.getElementById("restart-btn");
const generateBtn = document.getElementById("generate-btn");
const generateStatusEl = document.getElementById("generate-status");

const timerEl = document.getElementById("timer");
const progressEl = document.getElementById("progress");
const questionTextEl = document.getElementById("question-text");
const optionsEl = document.getElementById("options");
const feedbackEl = document.getElementById("feedback");
const resultTitleEl = document.getElementById("result-title");
const scoreTextEl = document.getElementById("score-text");
const passFailEl = document.getElementById("pass-fail");
const reviewListEl = document.getElementById("review-list");

let questions = [];
let currentIndex = 0;
let userAnswers = [];
let remainingSeconds = EXAM_DURATION_SECONDS;
let timerInterval = null;
let examFinished = false;
let examInProgress = false;

function shuffle(array) {
  const result = array.slice();
  for (let i = result.length - 1; i > 0; i -= 1) {
    const j = Math.floor(Math.random() * (i + 1));
    [result[i], result[j]] = [result[j], result[i]];
  }
  return result;
}

/** Mirrors GenerateQuestions.kt: shuffles question and option order client-side. */
function generateQuestionSet() {
  const count = Math.min(EXAM_QUESTION_COUNT, questionBank.length);
  return shuffle(questionBank)
    .slice(0, count)
    .map((question) => {
      const options = shuffle([question.correctOption, ...question.incorrectOptions]);
      const correctIndex = options.indexOf(question.correctOption);
      return { question: question.text, options, correctIndex };
    });
}

function generateQuestions() {
  if (examInProgress) {
    return;
  }
  const generated = generateQuestionSet();
  localStorage.setItem(GENERATED_QUESTIONS_KEY, JSON.stringify(generated));
  generateStatusEl.textContent = `Generated ${generated.length} questions.`;
}

async function loadQuestions() {
  const stored = localStorage.getItem(GENERATED_QUESTIONS_KEY);
  if (stored) {
    return JSON.parse(stored);
  }
  const response = await fetch("questions.json", { cache: "no-store" });
  if (!response.ok) {
    throw new Error(`Failed to load questions.json: ${response.status}`);
  }
  return response.json();
}

function showScreen(screen) {
  [startScreen, quizScreen, resultScreen].forEach((s) => s.classList.add("hidden"));
  screen.classList.remove("hidden");
}

function formatTime(totalSeconds) {
  const hours = Math.floor(totalSeconds / 3600);
  const minutes = Math.floor((totalSeconds % 3600) / 60);
  const seconds = totalSeconds % 60;
  return `${hours}:${String(minutes).padStart(2, "0")}:${String(seconds).padStart(2, "0")}`;
}

function updateTimerDisplay() {
  timerEl.textContent = `Time left: ${formatTime(Math.max(remainingSeconds, 0))}`;
  timerEl.classList.toggle("low-time", remainingSeconds <= LOW_TIME_WARNING_SECONDS);
}

function startTimer() {
  remainingSeconds = EXAM_DURATION_SECONDS;
  timerEl.classList.remove("hidden");
  updateTimerDisplay();
  timerInterval = setInterval(() => {
    remainingSeconds -= 1;
    updateTimerDisplay();
    if (remainingSeconds <= 0) {
      finishExam();
    }
  }, 1000);
}

function stopTimer() {
  clearInterval(timerInterval);
  timerInterval = null;
  timerEl.classList.add("hidden");
}

function renderQuestion() {
  feedbackEl.textContent = "";
  nextBtn.disabled = userAnswers[currentIndex] === null;
  nextBtn.textContent = currentIndex === questions.length - 1 ? "Finish" : "Next";

  const q = questions[currentIndex];
  progressEl.textContent = `Question ${currentIndex + 1} of ${questions.length}`;
  questionTextEl.textContent = q.question;

  optionsEl.innerHTML = "";
  q.options.forEach((optionText, index) => {
    const btn = document.createElement("button");
    btn.className = "option-btn";
    if (userAnswers[currentIndex] === index) {
      btn.classList.add("selected");
    }
    btn.textContent = optionText;
    btn.addEventListener("click", () => selectOption(index));
    optionsEl.appendChild(btn);
  });
}

function selectOption(selectedIndex) {
  userAnswers[currentIndex] = selectedIndex;
  Array.from(optionsEl.children).forEach((btn, index) => {
    btn.classList.toggle("selected", index === selectedIndex);
  });
  nextBtn.disabled = false;
}

function goToNext() {
  currentIndex += 1;
  if (currentIndex >= questions.length) {
    finishExam();
  } else {
    renderQuestion();
  }
}

function finishExam() {
  if (examFinished) return;
  examFinished = true;
  examInProgress = false;
  stopTimer();

  let score = 0;
  reviewListEl.innerHTML = "";

  questions.forEach((q, index) => {
    const userAnswerIndex = userAnswers[index];
    if (userAnswerIndex === q.correctIndex) {
      score += 1;
      return;
    }

    const item = document.createElement("div");
    item.className = "review-item";

    const questionEl = document.createElement("div");
    questionEl.className = "review-question";
    questionEl.textContent = `${index + 1}. ${q.question}`;
    item.appendChild(questionEl);

    const yourAnswerEl = document.createElement("div");
    yourAnswerEl.className = "your-answer";
    yourAnswerEl.textContent =
      userAnswerIndex === null || userAnswerIndex === undefined
        ? "Your answer: (no answer selected)"
        : `Your answer: ${q.options[userAnswerIndex]}`;
    item.appendChild(yourAnswerEl);

    const correctAnswerEl = document.createElement("div");
    correctAnswerEl.className = "correct-answer";
    correctAnswerEl.textContent = `Correct answer: ${q.options[q.correctIndex]}`;
    item.appendChild(correctAnswerEl);

    reviewListEl.appendChild(item);
  });

  const passThreshold = Math.ceil(questions.length * PASS_RATIO);
  const passed = score >= passThreshold;

  resultTitleEl.textContent = remainingSeconds <= 0 ? "Time's Up" : "Exam Complete";
  scoreTextEl.textContent = `You scored ${score} out of ${questions.length} (need ${passThreshold} to pass).`;
  passFailEl.textContent = passed ? "PASS" : "FAIL";
  passFailEl.className = `pass-fail ${passed ? "pass" : "fail"}`;
  showScreen(resultScreen);
}

async function startExam() {
  currentIndex = 0;
  examFinished = false;
  examInProgress = true;
  try {
    questions = await loadQuestions();
  } catch (err) {
    questionTextEl.textContent = "Could not load questions.json. Run the generator first (./gradlew run).";
    showScreen(quizScreen);
    return;
  }
  userAnswers = new Array(questions.length).fill(null);
  showScreen(quizScreen);
  renderQuestion();
  startTimer();
}

function confirmFinishExam() {
  const unansweredCount = userAnswers.filter(
    (answer) => answer === null || answer === undefined
  ).length;
  if (unansweredCount > 0) {
    const message = `You have ${unansweredCount} unanswered question(s). They will be marked as failed. Finish exam now?`;
    if (!window.confirm(message)) {
      return;
    }
  }
  finishExam();
}

generateBtn.addEventListener("click", generateQuestions);
startBtn.addEventListener("click", startExam);
nextBtn.addEventListener("click", goToNext);
finishBtn.addEventListener("click", confirmFinishExam);
restartBtn.addEventListener("click", startExam);
