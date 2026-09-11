import java.io.File

/** Standard CCDV-F exam length. */
const val EXAM_QUESTION_COUNT = 53

/**
 * Reads [questionBank] from Questions.kt, shuffles the question order and each
 * question's options, takes the standard exam-length subset, then writes the
 * result as JSON for the web exam page to load.
 *
 * Run with: ./gradlew run
 * Each run produces a fresh random sequence (and, if the bank has more than
 * [EXAM_QUESTION_COUNT] questions, a fresh random subset too).
 */
fun main() {
    if (questionBank.size < EXAM_QUESTION_COUNT) {
        println(
            "Warning: question bank only has ${questionBank.size} questions, " +
                "fewer than the standard $EXAM_QUESTION_COUNT. Using all available."
        )
    }

    val shuffledQuestions = questionBank
        .shuffled()
        .take(EXAM_QUESTION_COUNT)
        .map { question ->
            val options = (listOf(question.correctOption) + question.incorrectOptions).shuffled()
            val correctIndex = options.indexOf(question.correctOption)
            ShuffledQuestion(question.text, options, correctIndex)
        }

    val json = toJson(shuffledQuestions)

    val outputFile = File("web/questions.json")
    outputFile.parentFile?.mkdirs()
    outputFile.writeText(json)

    println("Generated ${shuffledQuestions.size} questions in random order -> ${outputFile.path}")
}

private data class ShuffledQuestion(
    val text: String,
    val options: List<String>,
    val correctIndex: Int
)

private fun toJson(questions: List<ShuffledQuestion>): String = buildString {
    append("[\n")
    questions.forEachIndexed { index, q ->
        append("  {\n")
        append("    \"question\": \"${q.text.jsonEscape()}\",\n")
        append("    \"options\": [")
        append(q.options.joinToString(", ") { "\"${it.jsonEscape()}\"" })
        append("],\n")
        append("    \"correctIndex\": ${q.correctIndex}\n")
        append("  }")
        append(if (index != questions.lastIndex) ",\n" else "\n")
    }
    append("]\n")
}

private fun String.jsonEscape(): String = buildString {
    for (c in this@jsonEscape) {
        when (c) {
            '"' -> append("\\\"")
            '\\' -> append("\\\\")
            '\n' -> append("\\n")
            '\r' -> append("\\r")
            '\t' -> append("\\t")
            else -> append(c)
        }
    }
}
