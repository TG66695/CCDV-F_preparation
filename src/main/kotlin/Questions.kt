/**
 * Question bank for the CCDV-F ("Claude Certified Developer - Foundations") practice exam.
 *
 * These are original practice questions grounded in the exam's real 8 content domains
 * (Applications and Integration; Model Selection and Optimization; Prompt and Context
 * Engineering; Agents and Workflows; Claude Code; Eval, Testing and Debugging; Security
 * and Safety; Tools and MCPs) - they are NOT actual leaked or official exam questions,
 * since Anthropic does not publish those. Replace or extend entries below with your own
 * study material as needed.
 *
 * To add or change questions, edit [questionBank] below.
 * The first option in the list is always treated as the correct one -
 * the generator shuffles both question order and option order at runtime,
 * so there is no need to track indexes by hand.
 */
data class Question(
    val text: String,
    val correctOption: String,
    val incorrectOptions: List<String>
) {
    init {
        require(incorrectOptions.size == 3) {
            "Each question needs exactly 3 incorrect options (4 total with the correct one)."
        }
    }
}

val questionBank: List<Question> = listOf(
    // --- Applications and Integration ---
    Question(
        text = "Which Claude API feature allows a response to be delivered incrementally as it is generated, rather than waiting for the full completion?",
        correctOption = "Streaming responses (server-sent events)",
        incorrectOptions = listOf("Batch processing", "Prompt caching", "Extended thinking")
    ),
    Question(
        text = "What is the primary benefit of using the Batch API for large volumes of non-urgent requests?",
        correctOption = "Significantly reduced cost per request in exchange for asynchronous, delayed processing",
        incorrectOptions = listOf(
            "Guaranteed lower latency than standard requests",
            "Unlimited context window size",
            "Automatic fine-tuning of the model"
        )
    ),
    Question(
        text = "When a Claude API request exceeds the model's context window, what is the typical result?",
        correctOption = "The API returns an error indicating the token limit was exceeded",
        incorrectOptions = listOf(
            "The oldest messages are automatically summarized and resent",
            "The request is automatically split into multiple calls",
            "The model silently truncates the response only"
        )
    ),
    Question(
        text = "What is 'structured output' in the context of the Claude API primarily used for?",
        correctOption = "Constraining the model's response to a defined schema, such as JSON, for reliable downstream parsing",
        incorrectOptions = listOf(
            "Formatting the model's response with markdown headers only",
            "Compressing the response to save tokens",
            "Encrypting sensitive fields in the response"
        )
    ),
    Question(
        text = "Which HTTP status code family typically indicates a client-side error, such as a malformed request, when calling the Claude API?",
        correctOption = "4xx",
        incorrectOptions = listOf("2xx", "3xx", "5xx")
    ),
    Question(
        text = "What is a common software engineering practice when integrating an LLM API into a production application to handle transient failures?",
        correctOption = "Implementing retries with exponential backoff",
        incorrectOptions = listOf(
            "Retrying immediately in a tight loop with no delay",
            "Disabling error handling to simplify the code",
            "Caching every error response as if it were a success"
        )
    ),
    Question(
        text = "Why might a developer choose to use tool use (function calling) in a Claude application?",
        correctOption = "To let the model request structured actions, such as calling an external API, in a predictable format",
        incorrectOptions = listOf(
            "To reduce the size of the model itself",
            "To bypass the need for a system prompt",
            "To make responses render only as plain text"
        )
    ),
    Question(
        text = "What is the purpose of a system prompt when designing a Claude-powered application?",
        correctOption = "To set persistent instructions, role, and constraints that apply across the conversation",
        incorrectOptions = listOf(
            "To store the user's authentication token",
            "To define the network address of the API",
            "To cache previous responses for reuse"
        )
    ),
    Question(
        text = "In application design, what is a key consideration when exposing an LLM-powered feature directly to end users?",
        correctOption = "Handling unpredictable or malformed model outputs gracefully in the UI",
        incorrectOptions = listOf(
            "Assuming the model will never produce unexpected output",
            "Removing all error handling to simplify the UI",
            "Disabling logging to save storage"
        )
    ),
    Question(
        text = "What does idempotency mean in the context of API integration, and why does it matter for Claude API calls?",
        correctOption = "Repeating the same request produces the same effect, which helps safely handle retries",
        incorrectOptions = listOf(
            "Every request must return an identical response body regardless of input",
            "The API automatically deduplicates all requests",
            "It means the API call cannot be retried under any circumstance"
        )
    ),
    Question(
        text = "When designing a multi-turn conversational application, what is the standard way to give Claude memory of prior turns?",
        correctOption = "Including the prior conversation turns as messages in the request payload",
        incorrectOptions = listOf(
            "The API automatically remembers all past conversations server-side by default",
            "Using a separate model fine-tuned per user",
            "Storing memory exclusively in the system prompt and nowhere else"
        )
    ),
    Question(
        text = "What is a typical reason to use asynchronous processing when integrating Claude into a backend service?",
        correctOption = "To avoid blocking the main application thread while waiting on a potentially slow model response",
        incorrectOptions = listOf(
            "To make the model produce more accurate answers",
            "To avoid the need for authentication",
            "To reduce the number of tokens used per request"
        )
    ),
    Question(
        text = "Which of the following best describes 'rate limiting' in the context of API integration?",
        correctOption = "Restricting the number of requests a client can make in a given time period",
        incorrectOptions = listOf(
            "Reducing the quality of model responses over time",
            "Limiting the number of users who can create an account",
            "Slowing down the model's internal reasoning speed"
        )
    ),
    Question(
        text = "What is a key benefit of validating and sanitizing user input before sending it to the Claude API in an application?",
        correctOption = "Reducing the risk of prompt injection and malformed requests",
        incorrectOptions = listOf(
            "Making the request smaller so it always fits any context window",
            "Guaranteeing the model will never make a mistake",
            "Removing the need for a system prompt entirely"
        )
    ),
    Question(
        text = "In a production application, why is it important to log requests and responses to and from the Claude API (with appropriate privacy safeguards)?",
        correctOption = "To support debugging, monitoring, and auditing of application behavior",
        incorrectOptions = listOf(
            "Logging is unnecessary since the API guarantees correctness",
            "To increase the token limit of future requests",
            "To automatically train a custom model"
        )
    ),
    Question(
        text = "What is a common architecture pattern for combining Claude with a company's private knowledge base?",
        correctOption = "Retrieval-augmented generation (RAG), where relevant documents are fetched and included in the prompt",
        incorrectOptions = listOf(
            "Directly embedding the entire database into the model's weights",
            "Sending the model a link to the database instead of content",
            "Disabling the system prompt so the model can access files directly"
        )
    ),
    Question(
        text = "Why might a developer version and pin a specific model identifier in production code rather than always using the latest alias?",
        correctOption = "To ensure consistent, predictable behavior and avoid unexpected changes when a new model version is released",
        incorrectOptions = listOf(
            "Pinned versions are always cheaper than the latest version",
            "Only pinned versions support streaming",
            "The API rejects all non-pinned model identifiers"
        )
    ),
    Question(
        text = "What is a key software engineering foundation relevant to building reliable Claude-powered applications?",
        correctOption = "Writing automated tests that verify application behavior, including how it handles model responses",
        incorrectOptions = listOf(
            "Avoiding version control for AI-related code",
            "Skipping code review for AI-integrated features",
            "Hardcoding all prompts directly into the UI layer with no separation of concerns"
        )
    ),

    // --- Model Selection and Optimization ---
    Question(
        text = "When choosing between a smaller/faster model and a larger/more capable model for a task, what is the primary trade-off?",
        correctOption = "Balancing response latency and cost against task accuracy and reasoning capability",
        incorrectOptions = listOf(
            "Smaller models always produce better quality output",
            "Larger models always have lower latency",
            "There is no meaningful difference between model sizes"
        )
    ),
    Question(
        text = "What is 'prompt caching' primarily designed to optimize?",
        correctOption = "Reducing cost and latency by reusing previously processed portions of a prompt across requests",
        incorrectOptions = listOf(
            "Improving the creativity of model responses",
            "Increasing the maximum context window size",
            "Encrypting prompts for security purposes"
        )
    ),
    Question(
        text = "Why might a developer use a smaller/faster model for a high-volume, simple classification task rather than the most capable model available?",
        correctOption = "To reduce cost and latency when the simpler task does not require the largest model's full reasoning capability",
        incorrectOptions = listOf(
            "Smaller models always produce more accurate results for every task",
            "Larger models cannot be used for classification tasks",
            "Cost and latency are irrelevant to model selection"
        )
    ),
    Question(
        text = "What does 'context window' refer to when discussing model capability?",
        correctOption = "The maximum amount of text (in tokens) the model can consider at once, including input and output",
        incorrectOptions = listOf(
            "The visual window size of the developer's screen",
            "The number of API keys a project can have",
            "The number of users who can call the API simultaneously"
        )
    ),
    Question(
        text = "How does token usage typically relate to the cost of a Claude API call?",
        correctOption = "Cost scales with the number of input and output tokens processed",
        incorrectOptions = listOf(
            "Cost is a fixed flat fee regardless of tokens used",
            "Cost depends only on the number of API calls, not tokens",
            "Token usage only affects latency, never cost"
        )
    ),
    Question(
        text = "What is a practical way to reduce token usage and cost without sacrificing necessary context?",
        correctOption = "Trimming irrelevant conversation history or documents from the prompt before sending it",
        incorrectOptions = listOf(
            "Always sending the entire conversation history in full regardless of relevance",
            "Increasing the temperature parameter",
            "Disabling streaming responses"
        )
    ),
    Question(
        text = "Extended thinking (showing the model's step-by-step reasoning before a final answer) is generally most useful for which type of task?",
        correctOption = "Complex, multi-step reasoning or analysis tasks",
        incorrectOptions = listOf(
            "Simple lookups that require no reasoning",
            "Tasks that must respond with the fewest possible tokens",
            "Tasks where latency must be minimized above all else"
        )
    ),
    Question(
        text = "What is a key consideration when selecting a model for a latency-sensitive, real-time user-facing feature?",
        correctOption = "Preferring a faster model or streaming responses to minimize perceived wait time",
        incorrectOptions = listOf(
            "Always choosing the largest available model regardless of speed",
            "Disabling error handling to save time",
            "Increasing the context window as much as possible"
        )
    ),
    Question(
        text = "Why might an application use different models for different subtasks within the same workflow?",
        correctOption = "To match each subtask's complexity to an appropriately sized model, optimizing overall cost and performance",
        incorrectOptions = listOf(
            "Because a single model cannot be reused across multiple calls",
            "Because the API requires alternating models on every request",
            "Because using one model everywhere is against API terms of service"
        )
    ),

    // --- Prompt and Context Engineering ---
    Question(
        text = "What is the primary purpose of providing few-shot examples in a prompt?",
        correctOption = "To demonstrate the desired input/output pattern so the model can follow it more reliably",
        incorrectOptions = listOf(
            "To increase the model's context window size",
            "To reduce the number of tokens used",
            "To bypass the need for a system prompt"
        )
    ),
    Question(
        text = "Why is being specific and explicit in a prompt generally more effective than a vague instruction?",
        correctOption = "It reduces ambiguity, helping the model produce output that matches the intended goal",
        incorrectOptions = listOf(
            "Specific prompts always use fewer tokens than vague ones",
            "Vague prompts are rejected by the API",
            "Specificity guarantees zero errors regardless of task difficulty"
        )
    ),
    Question(
        text = "What is a common technique for guiding a model to reason step-by-step before giving a final answer?",
        correctOption = "Explicitly asking the model to think through the problem before responding, or using an extended thinking mode",
        incorrectOptions = listOf(
            "Reducing the prompt to a single word",
            "Disabling the system prompt entirely",
            "Sending the request without any instructions"
        )
    ),
    Question(
        text = "When managing a long conversation that risks exceeding the context window, what is a common context engineering strategy?",
        correctOption = "Summarizing or pruning older parts of the conversation while retaining key information",
        incorrectOptions = listOf(
            "Sending the entire raw conversation history forever with no changes",
            "Increasing the temperature parameter to compress context",
            "Disabling the system prompt to save space"
        )
    ),
    Question(
        text = "What role does a well-defined system prompt play in context engineering for an agent?",
        correctOption = "It establishes consistent behavior, constraints, and role framing that persists across the interaction",
        incorrectOptions = listOf(
            "It replaces the need for any tool definitions",
            "It is only used for logging purposes",
            "It has no effect on model behavior"
        )
    ),
    Question(
        text = "Why is it useful to include clear formatting instructions (e.g., 'respond only in JSON') in a prompt when the output will be parsed programmatically?",
        correctOption = "It increases the likelihood the response can be reliably parsed without additional post-processing",
        incorrectOptions = listOf(
            "It guarantees the model can never make a formatting mistake",
            "It reduces the model's token cost to zero",
            "It disables the model's reasoning ability"
        )
    ),

    // --- Agents and Workflows ---
    Question(
        text = "What is the core loop that an agent built with a tool-use capable model typically follows?",
        correctOption = "The model decides whether to call a tool, executes it, observes the result, and repeats until it can produce a final answer",
        incorrectOptions = listOf(
            "The model always produces a final answer immediately without calling any tools",
            "The model requires a human to manually approve every internal reasoning step",
            "The model can only call one tool per entire session"
        )
    ),
    Question(
        text = "What is a key benefit of using subagents in a multi-agent workflow?",
        correctOption = "Isolating a focused task's context and tool output from the main conversation to keep it manageable",
        incorrectOptions = listOf(
            "Subagents always run with no context at all",
            "Subagents replace the need for any tools",
            "Subagents guarantee zero cost for the task"
        )
    ),
    Question(
        text = "In an agentic workflow, why might a task be broken into multiple sequential agent calls rather than one large call?",
        correctOption = "To let each step focus on a smaller, more manageable piece of the problem and verify progress along the way",
        incorrectOptions = listOf(
            "Because a single agent call is not technically possible",
            "Because splitting always reduces total token usage to zero",
            "Because the API forbids more than one call per workflow"
        )
    ),
    Question(
        text = "What is a common failure mode to guard against when building autonomous agent loops?",
        correctOption = "The agent looping indefinitely or repeating the same failing action without making progress",
        incorrectOptions = listOf(
            "The agent completing the task too quickly",
            "The agent using too few tools",
            "The agent's context window being too large"
        )
    ),
    Question(
        text = "Why might a workflow run multiple independent agents in parallel rather than sequentially?",
        correctOption = "To reduce overall wall-clock time when the subtasks do not depend on each other's results",
        incorrectOptions = listOf(
            "Parallel execution always increases the total cost with no benefit",
            "Parallel agents cannot access tools",
            "Sequential execution is not supported by any agent framework"
        )
    ),

    // --- Claude Code ---
    Question(
        text = "What is the primary purpose of Claude Code as a developer tool?",
        correctOption = "To act as an agentic command-line coding assistant that can read, write, and execute code in a project",
        incorrectOptions = listOf(
            "To serve exclusively as a chat interface with no access to local files",
            "To replace version control systems entirely",
            "To only generate documentation, never code"
        )
    ),
    Question(
        text = "What are 'hooks' in the context of Claude Code?",
        correctOption = "User-configured shell commands that execute automatically in response to specific events, such as before or after a tool call",
        incorrectOptions = listOf(
            "Built-in keyboard shortcuts with no configuration options",
            "A type of AI model used only for code completion",
            "A billing feature for tracking API usage"
        )
    ),
    Question(
        text = "What is the purpose of a settings file (such as settings.json) in a Claude Code project?",
        correctOption = "To configure permissions, hooks, and other project- or user-level behavior for the tool",
        incorrectOptions = listOf(
            "To store the source code of the application being built",
            "To replace the need for a .gitignore file",
            "To define the database schema for the project"
        )
    ),
    Question(
        text = "Why might a developer configure an MCP server within Claude Code?",
        correctOption = "To give the assistant access to additional external tools or data sources beyond its built-in capabilities",
        incorrectOptions = listOf(
            "To disable all tool use entirely",
            "To reduce the number of files in the project",
            "To replace the need for a code editor"
        )
    ),

    // --- Eval, Testing and Debugging ---
    Question(
        text = "What is the main purpose of building an evaluation ('eval') suite for an LLM-powered feature?",
        correctOption = "To systematically measure how well the model performs against defined criteria before and after changes",
        incorrectOptions = listOf(
            "To replace the need for any human review of the product",
            "To reduce the number of tokens used per request",
            "To automatically fix bugs in the application code"
        )
    ),
    Question(
        text = "When debugging an agent that repeatedly calls the wrong tool, what is a useful first step?",
        correctOption = "Reviewing the tool descriptions and the agent's reasoning trace to see why it chose that tool",
        incorrectOptions = listOf(
            "Immediately removing all tools from the agent",
            "Increasing the model's temperature to add randomness",
            "Ignoring the issue since agents cannot be debugged"
        )
    ),
    Question(
        text = "Why is it useful to use an LLM as a judge in an evaluation pipeline?",
        correctOption = "To automatically score open-ended or subjective outputs at scale where exact-match grading is not practical",
        incorrectOptions = listOf(
            "It guarantees perfectly objective scoring with no possibility of error",
            "It removes the need for any evaluation criteria",
            "It only works for numeric outputs"
        )
    ),
    Question(
        text = "What is a good practice when writing test cases for a feature built on top of an LLM?",
        correctOption = "Including edge cases and adversarial inputs, not just the happy path",
        incorrectOptions = listOf(
            "Testing only the single most common input",
            "Skipping tests since LLM output is 'random' and untestable",
            "Testing exclusively in production with real users"
        )
    ),

    // --- Security and Safety ---
    Question(
        text = "What is 'prompt injection' in the context of LLM application security?",
        correctOption = "An attempt to manipulate a model's behavior by embedding malicious instructions in content it processes, such as a document or webpage",
        incorrectOptions = listOf(
            "A technique for increasing the speed of prompt processing",
            "A method for compressing prompts to save tokens",
            "A standard feature for customizing model responses"
        )
    ),
    Question(
        text = "What is the principle of least privilege as applied to tools available to an agent?",
        correctOption = "Granting an agent only the access and permissions necessary to complete its task, nothing more",
        incorrectOptions = listOf(
            "Granting every agent full administrative access by default",
            "Disabling all tools to maximize safety",
            "Granting broad access and revoking it only after an incident occurs"
        )
    ),
    Question(
        text = "Why should sensitive data, such as credentials, generally be kept out of prompts sent to an LLM?",
        correctOption = "To reduce the risk of exposure through logs, model outputs, or unintended context leakage",
        incorrectOptions = listOf(
            "Because the API cannot technically process sensitive data",
            "Because sensitive data always breaks JSON formatting",
            "Because it would exceed the context window automatically"
        )
    ),
    Question(
        text = "What is a reasonable safeguard when allowing an agent to execute shell commands or modify files autonomously?",
        correctOption = "Requiring confirmation or restricting permissions for destructive or irreversible actions",
        incorrectOptions = listOf(
            "Allowing every command to run without any review, since agents are always correct",
            "Removing all logging so actions are untraceable",
            "Disabling the ability to stop or interrupt the agent"
        )
    ),
    Question(
        text = "Why is content moderation or output filtering relevant to a customer-facing Claude application?",
        correctOption = "To reduce the risk of harmful, inappropriate, or policy-violating content reaching end users",
        incorrectOptions = listOf(
            "It is only relevant for internal tools, never customer-facing ones",
            "It replaces the need for a system prompt",
            "It guarantees the model will never make mistakes"
        )
    ),

    // --- Tools and MCPs ---
    Question(
        text = "What does MCP stand for in the context of tool integration with Claude?",
        correctOption = "Model Context Protocol",
        incorrectOptions = listOf("Managed Cloud Platform", "Multi-Client Processing", "Model Configuration Package")
    ),
    Question(
        text = "What is the purpose of a well-written tool description when defining a function the model can call?",
        correctOption = "To help the model understand when and how to correctly use that tool",
        incorrectOptions = listOf(
            "To document the tool for end users only, with no effect on model behavior",
            "To increase the token cost of every request",
            "To disable the tool by default"
        )
    ),
    Question(
        text = "What is a benefit of using the Model Context Protocol to expose tools to an AI assistant?",
        correctOption = "It provides a standardized way to connect external tools and data sources across different clients and assistants",
        incorrectOptions = listOf(
            "It only works with a single proprietary client and no others",
            "It eliminates the need to define any tool schema",
            "It requires rewriting the assistant's core model"
        )
    ),
    Question(
        text = "When a tool call returns an error, what is generally the best way for an agent to handle it?",
        correctOption = "Surface the error back to the model so it can decide how to adapt or retry",
        incorrectOptions = listOf(
            "Silently ignore the error and proceed as if it succeeded",
            "Immediately terminate the entire session with no explanation",
            "Automatically restart the whole conversation from scratch"
        )
    )
)
