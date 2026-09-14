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
    ),

    // --- Applications and Integration (additional) ---
    Question(
        text = "What is a typical use case for providing image input to the Claude API alongside text?",
        correctOption = "Having the model analyze visual content such as charts, screenshots, or diagrams alongside a text prompt",
        incorrectOptions = listOf(
            "Automatically converting images into fine-tuning data",
            "Bypassing the need for a system prompt",
            "Reducing the token cost of the request to zero"
        )
    ),
    Question(
        text = "What is the main advantage of using the Files API to upload a document once and reference it by ID in multiple requests?",
        correctOption = "It avoids re-uploading and re-processing the same content on every request, saving bandwidth and often cost",
        incorrectOptions = listOf(
            "It permanently fine-tunes the model on that document",
            "It guarantees the document will never be included in the context window",
            "It automatically translates the document into other languages"
        )
    ),
    Question(
        text = "What is the purpose of a citations feature when Claude answers questions based on provided source documents?",
        correctOption = "To ground the response in specific passages of the source material and let users verify claims against the original text",
        incorrectOptions = listOf(
            "To automatically summarize the entire document regardless of the question",
            "To remove the need for including the source documents in the prompt",
            "To encrypt the source documents for security"
        )
    ),
    Question(
        text = "When an application needs Claude to analyze a very long document that approaches the context window limit, what is a reasonable approach?",
        correctOption = "Splitting the document into chunks and processing or summarizing each chunk before combining results",
        incorrectOptions = listOf(
            "Always truncating the document silently and hoping nothing important was cut",
            "Increasing the temperature parameter to compensate",
            "Switching to synchronous processing only"
        )
    ),
    Question(
        text = "After submitting a large job to the Batch API, how does an application typically retrieve the results?",
        correctOption = "By polling the batch status endpoint (or being notified) until processing completes, then fetching the results",
        incorrectOptions = listOf(
            "Results are streamed back token-by-token in real time like a standard request",
            "The application must resubmit the same batch repeatedly until it succeeds",
            "Batch results are only available via a phone call to support"
        )
    ),
    Question(
        text = "What is a benefit of using an official Claude SDK (e.g., for Python or TypeScript) instead of calling the raw HTTP API directly?",
        correctOption = "It provides typed request/response objects, built-in retry logic, and other conveniences that reduce boilerplate",
        incorrectOptions = listOf(
            "It is the only way to authenticate with the API",
            "It removes the need to handle any errors",
            "It automatically reduces token usage for every request"
        )
    ),
    Question(
        text = "What does an HTTP 429 response from the Claude API typically indicate?",
        correctOption = "The client has exceeded a rate limit and should slow down or retry after a delay",
        incorrectOptions = listOf(
            "The request was successful but is being cached",
            "The model refused to answer for safety reasons",
            "The API key has been permanently revoked"
        )
    ),
    Question(
        text = "Why is it good practice to configure a client-side request timeout when calling the Claude API from an application?",
        correctOption = "To avoid the application hanging indefinitely if a response takes unusually long or the connection stalls",
        incorrectOptions = listOf(
            "Timeouts are required by the API and requests fail without one",
            "Timeouts increase the model's context window",
            "Timeouts guarantee a faster response from the model"
        )
    ),
    Question(
        text = "By default, does the Claude API retain memory of previous requests between separate API calls?",
        correctOption = "No, each request is stateless; the application must include relevant prior context explicitly in the messages",
        incorrectOptions = listOf(
            "Yes, the API automatically remembers every user's full history forever",
            "Yes, but only for users on an enterprise plan",
            "No, but the API automatically discards messages older than one turn even within the same request"
        )
    ),
    Question(
        text = "In a multimodal application, why might a request combine image input with tool use in the same conversation?",
        correctOption = "So the model can visually interpret an image and then take a structured action based on what it observed, such as looking up related data",
        incorrectOptions = listOf(
            "Because image input and tool use cannot be combined in a single request",
            "Because combining them disables the system prompt",
            "Because it is required for the API to accept any image at all"
        )
    ),
    Question(
        text = "What is a sound resilience practice for a production application if the Claude API becomes temporarily unavailable?",
        correctOption = "Falling back to a degraded experience, such as a cached response or a simplified feature, rather than failing completely",
        incorrectOptions = listOf(
            "Immediately deleting the user's session data",
            "Retrying the exact same request in an infinite tight loop",
            "Silently returning a fabricated success response with no output"
        )
    ),
    Question(
        text = "What is a safe way to roll out a significant change to a production prompt or system prompt?",
        correctOption = "Gradually rolling it out to a subset of traffic while monitoring quality metrics before a full rollout",
        incorrectOptions = listOf(
            "Deploying it to 100% of production traffic immediately with no monitoring",
            "Changing the prompt directly in the model's weights",
            "Skipping evaluation since prompt changes cannot affect behavior"
        )
    ),

    // --- Model Selection and Optimization (additional) ---
    Question(
        text = "What does the temperature parameter primarily control in a Claude API request?",
        correctOption = "The randomness or variability of the model's output, with lower values producing more deterministic responses",
        incorrectOptions = listOf(
            "The maximum number of tokens the model can generate",
            "The size of the context window available to the request",
            "The price charged per token"
        )
    ),
    Question(
        text = "What does the max_tokens parameter control in a Claude API request?",
        correctOption = "The maximum length of the model's generated response",
        incorrectOptions = listOf(
            "The maximum size of the input prompt that can be sent",
            "The number of tools the model is allowed to call",
            "The temperature used for sampling"
        )
    ),
    Question(
        text = "Why is it valuable to benchmark candidate models on your own task-specific evaluation set rather than relying solely on public benchmark leaderboards?",
        correctOption = "Public benchmarks may not reflect how a model performs on your application's specific data and requirements",
        incorrectOptions = listOf(
            "Public benchmarks are always inaccurate and should never be considered",
            "Task-specific benchmarking is required by the API before any request can be made",
            "Public benchmark scores automatically update your application's behavior"
        )
    ),
    Question(
        text = "How can prompt caching and the Batch API be combined to further optimize cost for large-scale, non-urgent workloads?",
        correctOption = "By reusing cached portions of a shared prompt prefix across many batched requests that share common context",
        incorrectOptions = listOf(
            "They cannot be used together under any circumstances",
            "Combining them always doubles the cost of each request",
            "Batch processing automatically disables prompt caching"
        )
    ),
    Question(
        text = "When a specific model version is scheduled for deprecation, what should a production application do?",
        correctOption = "Test and migrate to a supported replacement model before the deprecation date to avoid service disruption",
        incorrectOptions = listOf(
            "Nothing, since deprecated models continue working forever",
            "Immediately switch to the cheapest available model regardless of task fit",
            "Disable the application until Anthropic contacts the developer directly"
        )
    ),
    Question(
        text = "What is a common strategy when the input you need to send regularly exceeds the model's context window?",
        correctOption = "Chunking the input and processing or summarizing it in parts, then combining or iterating on the results",
        incorrectOptions = listOf(
            "Sending the full input anyway and ignoring the resulting error",
            "Switching the request to use a lower temperature",
            "Disabling the system prompt to make more room"
        )
    ),
    Question(
        text = "For a bulk data-processing job with no real-time user waiting, which factor should generally be prioritized over strict low latency?",
        correctOption = "Overall throughput and cost efficiency, since batch or asynchronous processing is more appropriate than optimizing for the fastest single response",
        incorrectOptions = listOf(
            "Minimizing latency is always the top priority regardless of use case",
            "Throughput is irrelevant to model selection",
            "Cost should never be considered when processing bulk data"
        )
    ),
    Question(
        text = "What is a relevant consideration when selecting a model for an application that must handle multiple languages well?",
        correctOption = "Evaluating the model's multilingual comprehension and generation quality for the specific languages required",
        incorrectOptions = listOf(
            "All models handle every language with identical quality",
            "Multilingual support has no bearing on model choice",
            "Only the largest possible context window matters for multilingual tasks"
        )
    ),
    Question(
        text = "What is a trade-off of using a 'latest' model alias instead of a specific pinned model version in a production system?",
        correctOption = "It automatically gets improvements over time but risks unexpected behavior changes when the underlying model updates",
        incorrectOptions = listOf(
            "Aliases are always slower than pinned versions",
            "Aliases cannot be used with streaming",
            "Pinned versions are not supported by the API"
        )
    ),
    Question(
        text = "What is 'model cascading' (or routing), where a cheap/fast model handles a request first and escalates to a larger model only when needed?",
        correctOption = "A cost-optimization pattern that uses a smaller model as a first pass and falls back to a more capable model only for harder cases",
        incorrectOptions = listOf(
            "A method for merging two models into a single set of weights",
            "A requirement enforced by the API for every request",
            "A way to bypass rate limits by alternating between models"
        )
    ),
    Question(
        text = "How does requesting a longer maximum response length typically affect cost, even if the model does not use all of it?",
        correctOption = "Cost is based on tokens actually generated, so a higher max_tokens limit alone does not increase cost unless more tokens are produced",
        incorrectOptions = listOf(
            "Cost is always charged for the full max_tokens value regardless of actual output length",
            "Longer max_tokens settings always reduce the cost of input tokens",
            "Max_tokens has no relationship to cost at all under any circumstance"
        )
    ),
    Question(
        text = "In a pipeline with a simple data-extraction step followed by a complex reasoning step, what is a sound model-selection approach?",
        correctOption = "Using a smaller, faster model for the extraction step and a more capable model for the complex reasoning step",
        incorrectOptions = listOf(
            "Using the most capable model for every step regardless of complexity to guarantee consistency",
            "Using the smallest model for every step to minimize cost regardless of task difficulty",
            "Alternating models randomly between steps"
        )
    ),

    // --- Prompt and Context Engineering (additional) ---
    Question(
        text = "Why do many effective Claude prompts use XML-style tags (e.g., <document>, <instructions>) to structure their content?",
        correctOption = "They clearly delineate different sections of the prompt, helping the model distinguish instructions from data",
        incorrectOptions = listOf(
            "XML tags are required by the API and requests fail without them",
            "XML tags reduce the number of tokens used to zero",
            "XML tags automatically translate the prompt into other languages"
        )
    ),
    Question(
        text = "What is 'role prompting' in the context of prompt engineering?",
        correctOption = "Assigning the model a specific persona or role (e.g., 'You are an experienced security auditor') to shape its tone and focus",
        incorrectOptions = listOf(
            "Restricting the model to only one API endpoint",
            "A method for authenticating API requests",
            "A way to bypass the context window limit"
        )
    ),
    Question(
        text = "Why is it generally more effective to tell a model what to do rather than only what not to do?",
        correctOption = "Positive instructions give the model a clear target behavior, whereas purely negative instructions can leave the desired behavior ambiguous",
        incorrectOptions = listOf(
            "Negative instructions are not processed by the model at all",
            "Positive instructions always use fewer tokens",
            "The API rejects prompts that contain negative instructions"
        )
    ),
    Question(
        text = "What is 'prefilling' the assistant's response used for in prompt engineering?",
        correctOption = "Starting the model's response with specific text (e.g., an opening brace) to steer it toward a desired format or continuation",
        incorrectOptions = listOf(
            "Pre-authorizing the API key before a request can be sent",
            "Automatically filling in the user's next message",
            "Caching the entire conversation history permanently"
        )
    ),
    Question(
        text = "What is a trade-off of prompting a model to reason step-by-step (chain-of-thought) before answering?",
        correctOption = "It can improve accuracy on complex tasks but increases token usage and response latency",
        incorrectOptions = listOf(
            "It always reduces both cost and latency",
            "It has no effect on the model's accuracy under any circumstance",
            "It disables the model's ability to use tools"
        )
    ),
    Question(
        text = "Why is it helpful to clearly delimit user-supplied or external data from developer instructions within a prompt?",
        correctOption = "It helps the model distinguish trusted instructions from untrusted content, reducing susceptibility to prompt injection",
        incorrectOptions = listOf(
            "Delimiters are purely cosmetic and have no effect on model behavior",
            "Delimiters reduce the token cost of the request to zero",
            "Delimiters are required syntax that the API enforces on every request"
        )
    ),
    Question(
        text = "What is a recommended practice when developing a prompt for a production feature?",
        correctOption = "Iteratively testing the prompt against representative examples and refining it based on observed failures",
        incorrectOptions = listOf(
            "Writing the prompt once and never revisiting it regardless of results",
            "Avoiding any testing since prompts cannot be evaluated systematically",
            "Only testing the prompt with a single example before shipping"
        )
    ),
    Question(
        text = "Why might a prompt include an example of an incorrect or undesired output alongside the correct one?",
        correctOption = "To help the model distinguish the desired behavior from a common mistake it should avoid",
        incorrectOptions = listOf(
            "Counter-examples are ignored by the model entirely",
            "Including any incorrect example always confuses the model into failing",
            "It is required to bypass the content moderation system"
        )
    ),
    Question(
        text = "In a very long prompt, why does the placement of critical instructions (e.g., near the beginning or end) matter?",
        correctOption = "Models can attend unevenly across a very long context, so placing key instructions prominently reduces the risk they are overlooked",
        incorrectOptions = listOf(
            "Placement has no effect since the model processes all tokens with perfectly equal attention regardless of position",
            "Instructions placed in the middle are always weighted more heavily",
            "The API automatically reorders the prompt for optimal placement"
        )
    ),
    Question(
        text = "When using few-shot examples, why is it often better to include a small number of highly relevant examples rather than many loosely related ones?",
        correctOption = "Relevant, well-chosen examples more reliably demonstrate the desired pattern without diluting the model's focus with noise",
        incorrectOptions = listOf(
            "More examples always improve output quality regardless of relevance",
            "The API enforces a strict maximum of one example per prompt",
            "Irrelevant examples are automatically filtered out by the model before processing"
        )
    ),
    Question(
        text = "Why is it useful to explicitly specify the desired tone, style, and length in a prompt for a customer-facing response?",
        correctOption = "It reduces ambiguity and increases the likelihood the output matches brand and format expectations without extra post-processing",
        incorrectOptions = listOf(
            "Tone and style cannot be influenced by prompt wording",
            "Specifying length always increases the cost of the request",
            "The API automatically infers the desired tone from the user's account settings"
        )
    ),
    Question(
        text = "What is a useful prompting technique to reduce fabricated answers when the required information may not be available in the given context?",
        correctOption = "Explicitly instructing the model to say it does not know or cannot find the answer rather than guessing",
        incorrectOptions = listOf(
            "Increasing the temperature parameter to maximize creativity",
            "Removing all instructions so the model responds freely",
            "Shortening the prompt to a single word to force a concise answer"
        )
    ),

    // --- Agents and Workflows (additional) ---
    Question(
        text = "What is the 'orchestrator-worker' pattern in agentic workflow design?",
        correctOption = "A lead agent breaks a task into subtasks and delegates them to specialized worker agents, then synthesizes their results",
        incorrectOptions = listOf(
            "A pattern where every agent works entirely independently with no coordination",
            "A requirement that only one agent may ever run per application",
            "A method for reducing an agent's context window to zero"
        )
    ),
    Question(
        text = "Why might a workflow include a human-in-the-loop checkpoint before an agent performs a high-stakes action?",
        correctOption = "To allow a person to review and approve consequential or irreversible actions before they are executed",
        incorrectOptions = listOf(
            "To slow down every single action regardless of risk, with no benefit",
            "Because agents are legally prohibited from acting without a human present at all times",
            "To eliminate the need for any logging of the agent's actions"
        )
    ),
    Question(
        text = "Why is it generally better to give an agent a small number of clearly distinct tools rather than many overlapping ones?",
        correctOption = "Overlapping tools with similar purposes make it harder for the model to reliably choose the correct one",
        incorrectOptions = listOf(
            "Agents can only ever be given exactly one tool",
            "More tools always improve an agent's accuracy regardless of overlap",
            "Tool count has no effect on an agent's tool-selection behavior"
        )
    ),
    Question(
        text = "In a multi-step agent workflow, how is relevant state typically carried from one step to the next?",
        correctOption = "By explicitly passing relevant results or summaries forward as part of the next step's input or context",
        incorrectOptions = listOf(
            "State is automatically remembered by the model with no need to pass anything",
            "Each step must be entirely unaware of all previous steps by design",
            "State can only be passed through a shared database, never through prompts"
        )
    ),
    Question(
        text = "When a tool call inside an agent loop fails due to a transient error, what is a reasonable design choice?",
        correctOption = "Allow the agent to retry the call, possibly with backoff, or adapt its approach based on the error",
        incorrectOptions = listOf(
            "Immediately terminate the entire application",
            "Silently treat the failure as a success and continue",
            "Permanently disable that tool for all future sessions"
        )
    ),
    Question(
        text = "Why should an autonomous agent loop have explicit termination conditions, such as a maximum number of steps?",
        correctOption = "To prevent the agent from running indefinitely or looping on a task it cannot complete, controlling cost and risk",
        incorrectOptions = listOf(
            "Termination conditions are only relevant for agents that never call tools",
            "Explicit termination conditions always cause the agent to fail immediately",
            "Agents cannot be configured with any step limits"
        )
    ),
    Question(
        text = "What is a benefit of having an agent produce an explicit plan before executing actions, rather than acting immediately?",
        correctOption = "It makes the agent's intended approach inspectable and correctable before any actions with real effects are taken",
        incorrectOptions = listOf(
            "Planning steps always eliminate the need for any tools",
            "Plans produced by an agent are never allowed to change once made",
            "Planning removes the need for a system prompt"
        )
    ),
    Question(
        text = "What is a practical way to control the cost of a long-running autonomous agent?",
        correctOption = "Setting a maximum number of steps, tool calls, or a token budget the agent cannot exceed",
        incorrectOptions = listOf(
            "Removing the model's ability to call any tools",
            "Running the agent exclusively on the most expensive available model",
            "Disabling all logging to reduce overhead"
        )
    ),
    Question(
        text = "What is the 'evaluator-optimizer' agentic pattern?",
        correctOption = "One agent generates a candidate output while a second agent critiques it, and the process repeats until the output meets quality criteria",
        incorrectOptions = listOf(
            "A pattern where a single agent both writes and grades its own homework with no independent check",
            "A billing feature that reduces API cost automatically",
            "A requirement that all agents share the exact same prompt"
        )
    ),
    Question(
        text = "What is the 'routing' pattern in agentic workflow design?",
        correctOption = "Classifying an incoming request and directing it to the most appropriate specialized prompt or agent to handle it",
        incorrectOptions = listOf(
            "Randomly assigning each request to any available agent regardless of fit",
            "A network-layer feature unrelated to prompt or agent design",
            "A pattern that requires every request to be handled by every agent"
        )
    ),
    Question(
        text = "When should a developer prefer a fixed, deterministic workflow over a fully autonomous agent?",
        correctOption = "When the steps and decision points of the task are well understood and predictable in advance",
        incorrectOptions = listOf(
            "Always, since autonomous agents should never be used for any task",
            "Never, since fixed workflows cannot call tools",
            "Only when the task requires no error handling at all"
        )
    ),
    Question(
        text = "When a lead agent delegates a subtask to a subagent, what is typically shared with that subagent?",
        correctOption = "A focused subset of context and instructions relevant to the delegated subtask, rather than the entire conversation history",
        incorrectOptions = listOf(
            "The subagent automatically receives full access to every other subagent's private context",
            "Nothing is shared; the subagent must infer the task with no information",
            "The subagent always receives the raw API keys of the lead agent"
        )
    ),

    // --- Claude Code (additional) ---
    Question(
        text = "What is the purpose of a CLAUDE.md file in a Claude Code project?",
        correctOption = "To provide persistent, project-specific context and instructions that Claude Code reads at the start of a session",
        incorrectOptions = listOf(
            "To store compiled binaries for the project",
            "To replace the project's README for end users",
            "To define the CI/CD pipeline configuration exclusively"
        )
    ),
    Question(
        text = "What are custom slash commands in Claude Code used for?",
        correctOption = "Defining reusable shortcuts that expand into a predefined prompt or workflow when invoked",
        incorrectOptions = listOf(
            "Changing the operating system's keyboard shortcuts",
            "Encrypting files within the project",
            "Replacing the need for a version control system"
        )
    ),
    Question(
        text = "What is the purpose of permission modes in Claude Code, such as requiring approval before running certain commands?",
        correctOption = "To let the user control which actions Claude Code can take autonomously versus which require explicit confirmation",
        incorrectOptions = listOf(
            "To determine which programming languages the tool can read",
            "To set the visual theme of the terminal interface",
            "To control the model's temperature parameter"
        )
    ),
    Question(
        text = "What is the benefit of using a 'plan mode' in Claude Code before making changes to a codebase?",
        correctOption = "It lets the developer review and approve an intended approach before any code is modified",
        incorrectOptions = listOf(
            "It permanently disables the ability to edit any files",
            "It automatically deploys the changes to production",
            "It skips all testing requirements for the change"
        )
    ),
    Question(
        text = "Why might Claude Code delegate part of a task to a subagent rather than handling everything in the main conversation?",
        correctOption = "To keep a focused task's exploration or tool output isolated, preventing it from cluttering the main conversation's context",
        incorrectOptions = listOf(
            "Subagents in Claude Code cannot read or write files",
            "Delegating to a subagent disables version control integration",
            "Subagents always require a separate billing account"
        )
    ),
    Question(
        text = "What does configuring an MCP server in Claude Code allow the assistant to do?",
        correctOption = "Access additional external tools, services, or data sources beyond its built-in file and shell capabilities",
        incorrectOptions = listOf(
            "Change the underlying model powering Claude Code",
            "Disable all built-in tools permanently",
            "Bypass the need for user permission on any action"
        )
    ),
    Question(
        text = "How can Claude Code assist with version control tasks such as committing changes or opening a pull request?",
        correctOption = "By running git and platform CLI commands (such as git commit or gh pr create) on the user's behalf, typically with confirmation for risky actions",
        incorrectOptions = listOf(
            "Claude Code cannot interact with git or GitHub in any way",
            "Claude Code automatically force-pushes to the main branch without review",
            "Claude Code replaces git entirely with a proprietary versioning system"
        )
    ),
    Question(
        text = "Why is it good practice to review the diff of changes Claude Code proposes before accepting them?",
        correctOption = "To catch unintended changes, bugs, or behavior the developer did not intend, since human oversight remains important",
        incorrectOptions = listOf(
            "Diffs are purely decorative and do not reflect real file changes",
            "Reviewing diffs is unnecessary since automated changes are always correct",
            "Diffs cannot be generated for AI-proposed changes"
        )
    ),
    Question(
        text = "Why might a long-running command be executed as a background task in Claude Code rather than blocking the conversation?",
        correctOption = "So the developer can continue interacting with Claude Code while the command completes, and be notified when it finishes",
        incorrectOptions = listOf(
            "Background tasks run on a completely different machine with no relation to the project",
            "Background execution is required for every command regardless of duration",
            "Background tasks cannot report their results back to the session"
        )
    ),
    Question(
        text = "What is the purpose of a custom 'skill' in Claude Code?",
        correctOption = "To package a reusable set of instructions or workflow for a recurring type of task so it can be invoked consistently",
        incorrectOptions = listOf(
            "To install a new operating system kernel module",
            "To permanently change the model's training data",
            "To replace the need for any project-specific configuration"
        )
    ),
    Question(
        text = "What typically happens as a Claude Code session grows very long and approaches the context window limit?",
        correctOption = "Earlier parts of the conversation may be summarized or compacted so the session can continue without losing essential context",
        incorrectOptions = listOf(
            "The session immediately and permanently terminates with all history lost",
            "The context window automatically doubles in size at no cost",
            "All previously edited files are automatically reverted"
        )
    ),
    Question(
        text = "What is the purpose of configuring an allowlist or denylist of permitted actions in Claude Code's settings?",
        correctOption = "To give the user fine-grained control over which specific commands or tools Claude Code may run automatically versus never or only with approval",
        incorrectOptions = listOf(
            "To control which files are visible in the file explorer only",
            "To set the color scheme used in the terminal",
            "To determine which programming language the project is written in"
        )
    ),

    // --- Eval, Testing and Debugging (additional) ---
    Question(
        text = "What is a 'golden dataset' in the context of evaluating an LLM-powered feature?",
        correctOption = "A curated set of representative inputs paired with expected or high-quality reference outputs used to measure performance",
        incorrectOptions = listOf(
            "A randomly generated set of inputs with no reference outputs",
            "The model's own training data",
            "A dataset that only contains failed examples"
        )
    ),
    Question(
        text = "Why should a developer re-run an evaluation suite after modifying a production prompt?",
        correctOption = "To check for regressions, ensuring the change did not degrade performance on previously working cases",
        incorrectOptions = listOf(
            "Evaluation suites only need to be run once, before the very first prompt is written",
            "Prompt changes cannot affect model behavior in a measurable way",
            "Re-running evaluations after a change is prohibited by the API terms of service"
        )
    ),
    Question(
        text = "Why might an evaluation pipeline use multiple metrics (e.g., exact match, semantic similarity, and human preference) instead of just one?",
        correctOption = "Different metrics capture different aspects of quality, and relying on a single metric can miss important failure modes",
        incorrectOptions = listOf(
            "Using more than one metric is not technically possible in an eval pipeline",
            "A single metric always perfectly captures every dimension of quality",
            "Multiple metrics are only used to increase the perceived complexity of a report"
        )
    ),
    Question(
        text = "What is the purpose of A/B testing two different prompt versions in a production application?",
        correctOption = "To compare their real-world performance on live traffic before fully committing to one version",
        incorrectOptions = listOf(
            "To permanently run both versions forever with no comparison",
            "To bypass the need for any prior offline evaluation",
            "To determine which version uses fewer API keys"
        )
    ),
    Question(
        text = "Why is it useful to log an agent's intermediate reasoning and tool calls (its 'trace') during development?",
        correctOption = "It allows developers to understand why the agent made a particular decision and diagnose unexpected behavior",
        incorrectOptions = listOf(
            "Traces are only useful for billing purposes",
            "Logging traces prevents the agent from ever making mistakes",
            "Traces replace the need for any evaluation metrics"
        )
    ),
    Question(
        text = "Since LLM outputs can vary between runs, what is a practical approach to testing behavior reliably?",
        correctOption = "Using a low or zero temperature where appropriate, and/or evaluating multiple samples against defined acceptance criteria",
        incorrectOptions = listOf(
            "Testing is impossible for any feature that uses an LLM",
            "Always using the maximum possible temperature to test the worst case only",
            "Ignoring output variability entirely and testing only once"
        )
    ),
    Question(
        text = "In an LLM-powered application, what might a unit test focus on that an end-to-end integration test would not?",
        correctOption = "Testing individual components in isolation, such as input validation or response-parsing logic, without calling the live model",
        incorrectOptions = listOf(
            "Unit tests always require calling the production model with real API credentials",
            "There is no meaningful difference between unit and integration tests for LLM applications",
            "Unit tests can only be written after the application has been fully deployed"
        )
    ),
    Question(
        text = "Why is it useful to categorize LLM application failures into a taxonomy such as hallucination, refusal, formatting error, and tool misuse?",
        correctOption = "It helps teams identify patterns and prioritize fixes for the most impactful or frequent categories of failure",
        incorrectOptions = listOf(
            "Categorizing failures has no practical use once a bug is found",
            "A single generic 'error' category is always sufficient for any analysis",
            "Failure categorization is only relevant for non-AI software"
        )
    ),
    Question(
        text = "What is a benefit of running continuous evaluation or monitoring on a live LLM feature, rather than evaluating only before launch?",
        correctOption = "It can catch quality degradation caused by model updates, data drift, or edge cases not seen during initial testing",
        incorrectOptions = listOf(
            "Continuous evaluation is redundant once a feature has passed its initial tests",
            "It eliminates the need for any pre-launch evaluation",
            "It automatically retrains the underlying model in real time"
        )
    ),
    Question(
        text = "When an LLM feature produces an unexpected output, what is a sound debugging sequence to follow?",
        correctOption = "Check the exact prompt and inputs sent, verify any tool outputs used, and confirm the model version, before assuming the model itself is at fault",
        incorrectOptions = listOf(
            "Immediately conclude the model is broken and switch providers",
            "Assume the output is correct and adjust the UI to hide the problem",
            "Delete the logs so the issue cannot recur"
        )
    ),
    Question(
        text = "What kind of test case is important to include when testing an agent that calls external tools?",
        correctOption = "Cases where a tool call fails, returns malformed data, or is called with missing or invalid arguments",
        incorrectOptions = listOf(
            "Only cases where every tool call succeeds perfectly on the first attempt",
            "Cases that do not involve any tool calls at all, since those are irrelevant",
            "Only the single most expensive tool available"
        )
    ),
    Question(
        text = "Why is it important to keep a held-out set of test examples separate from the examples used to iteratively refine a prompt?",
        correctOption = "To avoid overfitting the prompt to the specific examples seen during development, giving a more honest estimate of real-world performance",
        incorrectOptions = listOf(
            "Held-out sets are only relevant when fine-tuning a model's weights",
            "Using the same examples for both development and evaluation always gives a more accurate result",
            "A held-out set is required by the API before any request can be sent"
        )
    ),

    // --- Security and Safety (additional) ---
    Question(
        text = "What is 'indirect prompt injection'?",
        correctOption = "Malicious instructions embedded in external content (such as a webpage, email, or document) that an agent processes and may inadvertently follow",
        incorrectOptions = listOf(
            "A direct attack where a user types malicious commands into the chat interface",
            "A technique for speeding up prompt processing",
            "A standard, officially supported way to configure model behavior"
        )
    ),
    Question(
        text = "Why is it particularly risky to give an agent both access to sensitive internal data and the ability to make outbound network requests?",
        correctOption = "A compromised or manipulated agent could be tricked into leaking sensitive data to an external destination",
        incorrectOptions = listOf(
            "There is no additional risk as long as the agent uses a system prompt",
            "Outbound network requests are always blocked automatically for any agent",
            "Sensitive data access and network access can never coexist in a single agent"
        )
    ),
    Question(
        text = "Before executing a shell command or code snippet suggested by an agent, what is a reasonable safeguard?",
        correctOption = "Validating or reviewing the command for safety and correctness, especially for actions with real-world side effects",
        incorrectOptions = listOf(
            "Always executing it immediately with no review, since agents cannot make mistakes",
            "Disabling all shell access permanently for every agent",
            "Only reviewing commands that are shorter than ten characters"
        )
    ),
    Question(
        text = "Why should an application use scoped, least-privilege API keys or credentials for a Claude-powered feature rather than broad administrative credentials?",
        correctOption = "To limit the potential damage if the key is leaked or the feature is misused",
        incorrectOptions = listOf(
            "Scoped keys always provide faster API responses",
            "Broad administrative credentials are required for every Claude API call",
            "Scoping credentials has no effect on security"
        )
    ),
    Question(
        text = "What is a common way to restrict a customer-facing assistant from discussing off-topic or disallowed subjects?",
        correctOption = "Including explicit guardrail instructions in the system prompt, combined with output monitoring",
        incorrectOptions = listOf(
            "Guardrails can only be implemented by retraining the entire model",
            "There is no way to restrict what topics a deployed assistant discusses",
            "Guardrails are exclusively a hardware-level feature"
        )
    ),
    Question(
        text = "Why should code generated or executed by an autonomous agent typically run in a sandboxed environment?",
        correctOption = "To contain any unintended or malicious behavior and limit the code's access to the broader system",
        incorrectOptions = listOf(
            "Sandboxing is only relevant for code written by humans, never AI-generated code",
            "Sandboxing guarantees the generated code is functionally correct",
            "Sandboxes always make code execution slower with no security benefit"
        )
    ),
    Question(
        text = "What is an important security consideration before connecting an agent to a third-party MCP server?",
        correctOption = "Reviewing the trustworthiness and permissions of the server, since it can expose powerful tools and data access to the agent",
        incorrectOptions = listOf(
            "All MCP servers are vetted and secured automatically by the protocol itself",
            "MCP servers cannot access any external systems by design",
            "There is no security difference between local and third-party MCP servers"
        )
    ),
    Question(
        text = "Why should a customer-facing AI feature implement its own rate limiting or abuse detection in addition to the API's own limits?",
        correctOption = "To prevent a small number of users from overwhelming the feature or driving excessive cost through abusive usage patterns",
        incorrectOptions = listOf(
            "The API's rate limits make any additional application-level controls unnecessary",
            "Rate limiting always degrades the quality of every response",
            "Abuse prevention is only relevant for non-AI features"
        )
    ),
    Question(
        text = "Why is it important to maintain an audit log of actions an autonomous agent takes in a production system?",
        correctOption = "To provide accountability and a way to trace back what the agent did if something goes wrong",
        incorrectOptions = listOf(
            "Audit logs are only useful for marketing purposes",
            "Logging agent actions is prohibited for AI systems",
            "Audit logs eliminate the need for any other safeguard"
        )
    ),
    Question(
        text = "What is the purpose of red-teaming an LLM-powered application before it launches?",
        correctOption = "To proactively probe the system with adversarial inputs to find safety, security, or misuse vulnerabilities before real users encounter them",
        incorrectOptions = listOf(
            "To advertise the product to a team of external reviewers",
            "To measure only the application's response latency",
            "To replace the need for any functional testing"
        )
    ),
    Question(
        text = "Why should an autonomous agent typically require explicit human approval before performing an irreversible action, such as permanently deleting production data?",
        correctOption = "Because such actions cannot be undone if the agent misjudges the situation, making the cost of an error especially high",
        incorrectOptions = listOf(
            "Irreversible actions are always safer for an agent to perform without oversight",
            "Human approval is only required for reversible, low-risk actions",
            "Agents are incapable of ever taking irreversible actions"
        )
    ),
    Question(
        text = "When an agent processes content retrieved from a tool call or an external document, how should that content generally be treated?",
        correctOption = "As untrusted data that should not be blindly followed as instructions, since it could contain injected commands",
        incorrectOptions = listOf(
            "As fully trusted instructions equivalent to the system prompt",
            "As content that should always be executed immediately without inspection",
            "As irrelevant and safe to ignore entirely"
        )
    ),

    // --- Tools and MCPs (additional) ---
    Question(
        text = "What is the purpose of defining a tool's parameters using a JSON schema when registering it for model use?",
        correctOption = "To specify the expected structure and types of arguments so the model can generate valid, well-formed tool calls",
        incorrectOptions = listOf(
            "To encrypt the tool's implementation code",
            "To set the tool's pricing tier",
            "To disable the tool for all but administrator accounts"
        )
    ),
    Question(
        text = "In the Model Context Protocol, what is the general relationship between an MCP server and an MCP client?",
        correctOption = "The server exposes tools, resources, or prompts, while the client (such as an AI assistant application) connects to and consumes them",
        incorrectOptions = listOf(
            "The client and server are always the same running process",
            "The server is a type of AI model, and the client is a type of database",
            "MCP servers can only be used by a single hardcoded client application"
        )
    ),
    Question(
        text = "In MCP, what is the general distinction between a 'resource' and a 'tool'?",
        correctOption = "A resource typically exposes readable data or context, while a tool exposes an action the model can invoke",
        incorrectOptions = listOf(
            "Resources and tools are identical concepts with different names",
            "Resources can only be used for billing, and tools only for logging",
            "Tools are read-only, while resources always perform actions"
        )
    ),
    Question(
        text = "What problem can arise from registering multiple tools with very similar names and unclear descriptions?",
        correctOption = "The model may struggle to choose the correct tool, leading to incorrect or inconsistent tool calls",
        incorrectOptions = listOf(
            "The API automatically merges similarly named tools into one",
            "Overlapping tool names always improve the model's accuracy",
            "This situation is not technically possible to create"
        )
    ),
    Question(
        text = "What is a key difference between a local MCP server and a remote MCP server?",
        correctOption = "A local server typically runs on the same machine as the client, while a remote server is accessed over a network, often requiring authentication",
        incorrectOptions = listOf(
            "Local servers cannot expose any tools, only remote ones can",
            "Remote MCP servers are not supported by the protocol",
            "There is no functional difference between the two"
        )
    ),
    Question(
        text = "Why should a tool's result be returned in a concise, well-structured format rather than an overly verbose one?",
        correctOption = "To avoid wasting context window space and tokens, keeping the model focused on relevant information",
        incorrectOptions = listOf(
            "Verbose tool results always improve the model's accuracy",
            "Tool results are never included in the model's context",
            "Concise formatting is required only for billing calculations"
        )
    ),
    Question(
        text = "Why is it important to version a tool's schema as it evolves over time?",
        correctOption = "To avoid breaking existing integrations or agents that rely on the previous schema when parameters change",
        incorrectOptions = listOf(
            "Tool schemas never need to change once defined",
            "Versioning tool schemas is unrelated to backward compatibility",
            "Only the model's version needs to be tracked, never the tool's"
        )
    ),
    Question(
        text = "What does it mean when a model is capable of making 'parallel tool calls' in a single turn?",
        correctOption = "It can request multiple independent tool invocations at once instead of only one at a time, potentially reducing round trips",
        incorrectOptions = listOf(
            "It means the model can only ever call one tool per entire conversation",
            "It means tools are executed by multiple different AI models simultaneously",
            "It refers to running the same tool call twice for redundancy only"
        )
    ),
    Question(
        text = "What is the purpose of the 'prompts' feature that an MCP server can expose, in addition to tools and resources?",
        correctOption = "To provide reusable, parameterized prompt templates that clients can surface to users or the model",
        incorrectOptions = listOf(
            "To store the model's private weights",
            "To automatically bypass the need for a system prompt",
            "To replace the need for any tool definitions"
        )
    ),
    Question(
        text = "Why is authentication typically required when connecting to a remote MCP server?",
        correctOption = "To ensure only authorized clients can access the tools and data the server exposes, which may be sensitive",
        incorrectOptions = listOf(
            "Authentication is never required for any remote service",
            "Remote MCP servers do not expose any tools that require protection",
            "Authentication is only relevant for local MCP servers, never remote ones"
        )
    ),
    Question(
        text = "Why should an application validate the arguments in a model-generated tool call before executing the underlying action?",
        correctOption = "Because the model can occasionally produce malformed, incomplete, or unexpected arguments that could cause errors or unsafe behavior if executed blindly",
        incorrectOptions = listOf(
            "Model-generated tool calls are always guaranteed to be perfectly valid",
            "Validation is only necessary for tools that do not modify any data",
            "Validating arguments would violate the Model Context Protocol specification"
        )
    ),
    Question(
        text = "What is the benefit of an MCP client being able to dynamically discover the list of tools and resources a server currently exposes?",
        correctOption = "It allows the client to adapt to servers whose available capabilities may change, without requiring hardcoded knowledge in advance",
        incorrectOptions = listOf(
            "Dynamic discovery is a deprecated feature no longer supported by MCP",
            "It requires the client to be rebuilt every time a server is updated",
            "It eliminates the need for any tool schema definitions"
        )
    )
)
