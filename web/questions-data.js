/**
 * Question bank for the CCDV-F practice exam, mirroring src/main/kotlin/Questions.kt.
 * Keep this in sync with Questions.kt when questions are added or edited there.
 */
const questionBank = [
  // --- Applications and Integration ---
  {
    text: "Which Claude API feature allows a response to be delivered incrementally as it is generated, rather than waiting for the full completion?",
    correctOption: "Streaming responses (server-sent events)",
    incorrectOptions: ["Batch processing", "Prompt caching", "Extended thinking"]
  },
  {
    text: "What is the primary benefit of using the Batch API for large volumes of non-urgent requests?",
    correctOption: "Significantly reduced cost per request in exchange for asynchronous, delayed processing",
    incorrectOptions: [
      "Faster response times than standard requests, since batch jobs skip the normal request queue",
      "A larger context window than standard requests, allowing longer documents to be included",
      "Fine-tuning of the model on the submitted requests to improve future accuracy"
    ]
  },
  {
    text: "When a Claude API request exceeds the model's context window, what is the typical result?",
    correctOption: "The API returns an error indicating the token limit was exceeded",
    incorrectOptions: [
      "The oldest messages in the conversation are summarized and resent in a follow-up request",
      "The request is split into multiple smaller calls that are sent out in sequence",
      "The model truncates only its own response so the reply fits in the remaining space"
    ]
  },
  {
    text: "What is 'structured output' in the context of the Claude API primarily used for?",
    correctOption: "Constraining the model's response to a defined schema, such as JSON, for reliable downstream parsing",
    incorrectOptions: [
      "Formatting the model's response with markdown headers so it renders cleanly in a chat interface",
      "Compressing the model's response into fewer tokens to reduce the overall cost of the request",
      "Encrypting sensitive fields within the response so they cannot be read without a separate key"
    ]
  },
  {
    text: "Which HTTP status code family typically indicates a client-side error, such as a malformed request, when calling the Claude API?",
    correctOption: "4xx",
    incorrectOptions: ["2xx", "3xx", "5xx"]
  },
  {
    text: "What is a common software engineering practice when integrating an LLM API into a production application to handle transient failures?",
    correctOption: "Implementing retries with exponential backoff",
    incorrectOptions: [
      "Retrying the same request immediately in a loop until it eventually succeeds",
      "Turning off error handling in the client so failures pass through unnoticed",
      "Treating every error response as a success and caching it for later reuse"
    ]
  },
  {
    text: "Why might a developer choose to use tool use (function calling) in a Claude application?",
    correctOption: "To let the model request structured actions, such as calling an external API, in a predictable format",
    incorrectOptions: [
      "To reduce the number of parameters the underlying model needs to store",
      "To remove the need for a system prompt when defining the assistant's behavior",
      "To restrict the assistant's responses to plain text with no other formatting"
    ]
  },
  {
    text: "What is the purpose of a system prompt when designing a Claude-powered application?",
    correctOption: "To set persistent instructions, role, and constraints that apply across the conversation",
    incorrectOptions: [
      "To store the credentials the client uses to authenticate each request",
      "To specify the network endpoint the application sends its requests to",
      "To cache the model's previous responses so they can be reused later"
    ]
  },
  {
    text: "In application design, what is a key consideration when exposing an LLM-powered feature directly to end users?",
    correctOption: "Handling unpredictable or malformed model outputs gracefully in the UI",
    incorrectOptions: [
      "Assuming the model's output will always match the expected format exactly",
      "Simplifying the UI by leaving out any handling for unusual responses",
      "Turning off logging so the interface loads with slightly less overhead"
    ]
  },
  {
    text: "What does idempotency mean in the context of API integration, and why does it matter for Claude API calls?",
    correctOption: "Repeating the same request produces the same effect, which helps safely handle retries",
    incorrectOptions: [
      "Every request must return a response body that is byte-for-byte identical every time",
      "The API itself keeps track of duplicate requests and quietly discards the repeats",
      "It means a failed request should never be sent to the API a second time"
    ]
  },
  {
    text: "When designing a multi-turn conversational application, what is the standard way to give Claude memory of prior turns?",
    correctOption: "Including the prior conversation turns as messages in the request payload",
    incorrectOptions: [
      "The API keeps a server-side record of each user's past conversations",
      "Training a separate, personalized model instance for every individual user",
      "Writing all prior turns into the system prompt instead of the message list"
    ]
  },
  {
    text: "What is a typical reason to use asynchronous processing when integrating Claude into a backend service?",
    correctOption: "To avoid blocking the main application thread while waiting on a potentially slow model response",
    incorrectOptions: [
      "To improve the accuracy of the model's answers by giving it more processing time",
      "To remove the need to authenticate requests sent to the API",
      "To lower the number of tokens consumed by each individual request"
    ]
  },
  {
    text: "Which of the following best describes 'rate limiting' in the context of API integration?",
    correctOption: "Restricting the number of requests a client can make in a given time period",
    incorrectOptions: [
      "Gradually reducing the quality of responses as overall usage increases over time",
      "Capping how many user accounts can be created within an application",
      "Throttling how quickly the model can process its internal reasoning steps"
    ]
  },
  {
    text: "What is a key benefit of validating and sanitizing user input before sending it to the Claude API in an application?",
    correctOption: "Reducing the risk of prompt injection and malformed requests",
    incorrectOptions: [
      "Shrinking the request so it reliably fits within the context window",
      "Ensuring the model's output will be free of factual mistakes",
      "Removing the need to include a system prompt in the request"
    ]
  },
  {
    text: "In a production application, why is it important to log requests and responses to and from the Claude API (with appropriate privacy safeguards)?",
    correctOption: "To support debugging, monitoring, and auditing of application behavior",
    incorrectOptions: [
      "Because the API's own internal logs already cover this need",
      "To raise the token limit available to subsequent requests",
      "To automatically train a custom model on the logged data"
    ]
  },
  {
    text: "What is a common architecture pattern for combining Claude with a company's private knowledge base?",
    correctOption: "Retrieval-augmented generation (RAG), where relevant documents are fetched and included in the prompt",
    incorrectOptions: [
      "Fine-tuning the model directly on the entire contents of the knowledge base",
      "Passing the model a database connection string instead of retrieved content",
      "Giving the model direct file-system access in place of a system prompt"
    ]
  },
  {
    text: "Why might a developer version and pin a specific model identifier in production code rather than always using the latest alias?",
    correctOption: "To ensure consistent, predictable behavior and avoid unexpected changes when a new model version is released",
    incorrectOptions: [
      "Pinned model versions typically cost less per token than the latest alias",
      "Streaming responses are only available when a pinned model version is used",
      "Requests that reference an alias instead of a pinned version are rejected"
    ]
  },
  {
    text: "What is a key software engineering foundation relevant to building reliable Claude-powered applications?",
    correctOption: "Writing automated tests that verify application behavior, including how it handles model responses",
    incorrectOptions: [
      "Keeping AI-related code out of version control to iterate on it faster",
      "Skipping code review for features that call an LLM to move faster",
      "Embedding prompts directly in the UI layer instead of a shared module"
    ]
  },

  // --- Model Selection and Optimization ---
  {
    text: "When choosing between a smaller/faster model and a larger/more capable model for a task, what is the primary trade-off?",
    correctOption: "Balancing response latency and cost against task accuracy and reasoning capability",
    incorrectOptions: [
      "Smaller models tend to produce noticeably higher-quality output on most tasks",
      "Larger models generally respond with lower latency than smaller ones",
      "Model size mainly affects pricing tiers rather than response quality"
    ]
  },
  {
    text: "What is 'prompt caching' primarily designed to optimize?",
    correctOption: "Reducing cost and latency by reusing previously processed portions of a prompt across requests",
    incorrectOptions: [
      "Increasing the variety and creativity of the model's generated responses",
      "Expanding the maximum context window available for a single request",
      "Encrypting cached prompt segments so they cannot be inspected later"
    ]
  },
  {
    text: "Why might a developer use a smaller/faster model for a high-volume, simple classification task rather than the most capable model available?",
    correctOption: "To reduce cost and latency when the simpler task does not require the largest model's full reasoning capability",
    incorrectOptions: [
      "Smaller models tend to produce more accurate results on straightforward tasks",
      "Larger models are poorly suited to simple classification workloads in general",
      "Cost and latency are secondary concerns compared to raw model capability"
    ]
  },
  {
    text: "What does 'context window' refer to when discussing model capability?",
    correctOption: "The maximum amount of text (in tokens) the model can consider at once, including input and output",
    incorrectOptions: [
      "The size of the display area used to render the chat interface",
      "The maximum number of API keys that can be issued to a project",
      "The maximum number of concurrent users a project's API plan allows"
    ]
  },
  {
    text: "How does token usage typically relate to the cost of a Claude API call?",
    correctOption: "Cost scales with the number of input and output tokens processed",
    incorrectOptions: [
      "Cost is charged as a flat monthly fee independent of usage volume",
      "Cost is based mainly on the number of separate API calls made",
      "Token usage mostly affects how fast a response is returned, not its price"
    ]
  },
  {
    text: "What is a practical way to reduce token usage and cost without sacrificing necessary context?",
    correctOption: "Trimming irrelevant conversation history or documents from the prompt before sending it",
    incorrectOptions: [
      "Sending the full conversation history on every request regardless of relevance",
      "Adjusting the temperature parameter to make responses more concise",
      "Turning off streaming so responses arrive in a single batch"
    ]
  },
  {
    text: "Extended thinking (showing the model's step-by-step reasoning before a final answer) is generally most useful for which type of task?",
    correctOption: "Complex, multi-step reasoning or analysis tasks",
    incorrectOptions: [
      "Simple lookups that need little more than a direct answer",
      "Tasks that need to stay within a very small token budget",
      "Tasks where minimizing latency matters more than deep reasoning"
    ]
  },
  {
    text: "What is a key consideration when selecting a model for a latency-sensitive, real-time user-facing feature?",
    correctOption: "Preferring a faster model or streaming responses to minimize perceived wait time",
    incorrectOptions: [
      "Choosing the most capable available model regardless of its response speed",
      "Removing error-handling logic so the response reaches the user sooner",
      "Maximizing the context window so more history can be included"
    ]
  },
  {
    text: "Why might an application use different models for different subtasks within the same workflow?",
    correctOption: "To match each subtask's complexity to an appropriately sized model, optimizing overall cost and performance",
    incorrectOptions: [
      "Because reusing the same model instance across multiple calls degrades its accuracy",
      "Because the API requires each workflow to alternate between different models",
      "Because relying on one model for every subtask violates the API's terms of service"
    ]
  },

  // --- Prompt and Context Engineering ---
  {
    text: "What is the primary purpose of providing few-shot examples in a prompt?",
    correctOption: "To demonstrate the desired input/output pattern so the model can follow it more reliably",
    incorrectOptions: [
      "To expand the size of the context window available for that request",
      "To lower the overall number of tokens consumed by the prompt",
      "To remove the need to include a system prompt alongside them"
    ]
  },
  {
    text: "Why is being specific and explicit in a prompt generally more effective than a vague instruction?",
    correctOption: "It reduces ambiguity, helping the model produce output that matches the intended goal",
    incorrectOptions: [
      "Specific prompts generally consume fewer tokens than vague, open-ended ones",
      "Vague or ambiguous prompts are typically rejected before reaching the model",
      "Being specific removes the possibility of errors on any task, however hard"
    ]
  },
  {
    text: "What is a common technique for guiding a model to reason step-by-step before giving a final answer?",
    correctOption: "Explicitly asking the model to think through the problem before responding, or using an extended thinking mode",
    incorrectOptions: [
      "Shortening the prompt down to a single keyword to focus the model",
      "Removing the system prompt so the model reasons without prior constraints",
      "Sending the request with no instructions and letting the model infer intent"
    ]
  },
  {
    text: "When managing a long conversation that risks exceeding the context window, what is a common context engineering strategy?",
    correctOption: "Summarizing or pruning older parts of the conversation while retaining key information",
    incorrectOptions: [
      "Sending the full, unmodified conversation history with every new request",
      "Raising the temperature parameter so responses become more compact",
      "Removing the system prompt to free up room in the context"
    ]
  },
  {
    text: "What role does a well-defined system prompt play in context engineering for an agent?",
    correctOption: "It establishes consistent behavior, constraints, and role framing that persists across the interaction",
    incorrectOptions: [
      "It mainly serves as a substitute for defining the agent's tools",
      "It is primarily recorded for logging and auditing, not for guiding behavior",
      "It has only a minor, largely cosmetic effect on how the model responds"
    ]
  },
  {
    text: "Why is it useful to include clear formatting instructions (e.g., 'respond only in JSON') in a prompt when the output will be parsed programmatically?",
    correctOption: "It increases the likelihood the response can be reliably parsed without additional post-processing",
    incorrectOptions: [
      "It ensures the model's output will always be free of formatting mistakes",
      "It lowers the number of tokens the response consumes to almost nothing",
      "It limits how much reasoning the model can apply before responding"
    ]
  },

  // --- Agents and Workflows ---
  {
    text: "What is the core loop that an agent built with a tool-use capable model typically follows?",
    correctOption: "The model decides whether to call a tool, executes it, observes the result, and repeats until it can produce a final answer",
    incorrectOptions: [
      "The model produces a final answer right away and calls tools only afterward",
      "The model pauses for a human to approve each internal reasoning step",
      "The model is limited to a single tool call across an entire session"
    ]
  },
  {
    text: "What is a key benefit of using subagents in a multi-agent workflow?",
    correctOption: "Isolating a focused task's context and tool output from the main conversation to keep it manageable",
    incorrectOptions: [
      "Subagents run with the exact same context as the main conversation",
      "Subagents remove the need to define any tools for the workflow",
      "Subagents typically cost less to run than the main conversation itself"
    ]
  },
  {
    text: "In an agentic workflow, why might a task be broken into multiple sequential agent calls rather than one large call?",
    correctOption: "To let each step focus on a smaller, more manageable piece of the problem and verify progress along the way",
    incorrectOptions: [
      "Because a single large agent call tends to exceed most rate limits",
      "Because splitting the task generally lowers the total tokens used overall",
      "Because most agent frameworks limit a workflow to one call each"
    ]
  },
  {
    text: "What is a common failure mode to guard against when building autonomous agent loops?",
    correctOption: "The agent looping indefinitely or repeating the same failing action without making progress",
    incorrectOptions: [
      "The agent finishing the task earlier than expected with fewer steps",
      "The agent relying on only one or two tools for the whole task",
      "The agent's context window growing larger than the task actually needs"
    ]
  },
  {
    text: "Why might a workflow run multiple independent agents in parallel rather than sequentially?",
    correctOption: "To reduce overall wall-clock time when the subtasks do not depend on each other's results",
    incorrectOptions: [
      "Parallel execution mainly increases total cost without a clear speed benefit",
      "Agents running in parallel are generally unable to call external tools",
      "Most agent frameworks only support running steps one after another"
    ]
  },

  // --- Claude Code ---
  {
    text: "What is the primary purpose of Claude Code as a developer tool?",
    correctOption: "To act as an agentic command-line coding assistant that can read, write, and execute code in a project",
    incorrectOptions: [
      "To provide a chat interface for discussing code without touching local files",
      "To serve as a replacement for the project's version control system",
      "To generate project documentation without writing or running any code"
    ]
  },
  {
    text: "What are 'hooks' in the context of Claude Code?",
    correctOption: "User-configured shell commands that execute automatically in response to specific events, such as before or after a tool call",
    incorrectOptions: [
      "Fixed keyboard shortcuts that cannot be reconfigured by the user",
      "A specialized small model that only completes partial code and has no notion of shell commands or events",
      "A dashboard feature used only to track and report API usage costs across a project"
    ]
  },
  {
    text: "What is the purpose of a settings file (such as settings.json) in a Claude Code project?",
    correctOption: "To configure permissions, hooks, and other project- or user-level behavior for the tool",
    incorrectOptions: [
      "To hold the source files of the application currently being built",
      "To take the place of a .gitignore file for the repository",
      "To describe the database schema used by the project"
    ]
  },
  {
    text: "Why might a developer configure an MCP server within Claude Code?",
    correctOption: "To give the assistant access to additional external tools or data sources beyond its built-in capabilities",
    incorrectOptions: [
      "To turn off the assistant's built-in tool-use capabilities",
      "To reduce the number of files tracked within the project",
      "To remove the need to use a separate code editor"
    ]
  },

  // --- Eval, Testing and Debugging ---
  {
    text: "What is the main purpose of building an evaluation ('eval') suite for an LLM-powered feature?",
    correctOption: "To systematically measure how well the model performs against defined criteria before and after changes",
    incorrectOptions: [
      "To remove the need for people to review the product before release",
      "To lower the number of tokens each production request consumes",
      "To automatically patch bugs found in the surrounding application code"
    ]
  },
  {
    text: "When debugging an agent that repeatedly calls the wrong tool, what is a useful first step?",
    correctOption: "Reviewing the tool descriptions and the agent's reasoning trace to see why it chose that tool",
    incorrectOptions: [
      "Removing every tool from the agent until the behavior disappears",
      "Raising the model's temperature so it behaves less predictably",
      "Leaving the issue alone since agent behavior is hard to trace"
    ]
  },
  {
    text: "Why is it useful to use an LLM as a judge in an evaluation pipeline?",
    correctOption: "To automatically score open-ended or subjective outputs at scale where exact-match grading is not practical",
    incorrectOptions: [
      "It produces scoring that is fully objective and free of any bias",
      "It removes the need to define any grading criteria beforehand",
      "It is limited to grading strictly numeric outputs"
    ]
  },
  {
    text: "What is a good practice when writing test cases for a feature built on top of an LLM?",
    correctOption: "Including edge cases and adversarial inputs, not just the happy path",
    incorrectOptions: [
      "Focusing tests mainly on the single most common input pattern",
      "Skipping most testing since LLM output varies from run to run",
      "Relying mainly on production traffic with real users to catch issues"
    ]
  },

  // --- Security and Safety ---
  {
    text: "What is 'prompt injection' in the context of LLM application security?",
    correctOption: "An attempt to manipulate a model's behavior by embedding malicious instructions in content it processes, such as a document or webpage",
    incorrectOptions: [
      "A technique for speeding up how quickly a long prompt is processed",
      "A method used purely for shrinking prompts so they consume noticeably fewer tokens overall",
      "A supported way for developers to customize the tone and style of the assistant's responses"
    ]
  },
  {
    text: "What is the principle of least privilege as applied to tools available to an agent?",
    correctOption: "Granting an agent only the access and permissions necessary to complete its task, nothing more",
    incorrectOptions: [
      "Giving every agent broad administrative access as a starting default",
      "Removing all tool access from an agent to keep it safe",
      "Granting wide-ranging access up front and narrowing it only after a problem occurs"
    ]
  },
  {
    text: "Why should sensitive data, such as credentials, generally be kept out of prompts sent to an LLM?",
    correctOption: "To reduce the risk of exposure through logs, model outputs, or unintended context leakage",
    incorrectOptions: [
      "Because the model is technically unable to process that kind of data",
      "Because sensitive values tend to break JSON formatting when included",
      "Because including it would push most requests past the context window"
    ]
  },
  {
    text: "What is a reasonable safeguard when allowing an agent to execute shell commands or modify files autonomously?",
    correctOption: "Requiring confirmation or restricting permissions for destructive or irreversible actions",
    incorrectOptions: [
      "Letting commands run without review, since agent output is usually reliable",
      "Turning off action logging to reduce overhead during long sessions",
      "Removing the option to pause or interrupt the agent mid-task"
    ]
  },
  {
    text: "Why is content moderation or output filtering relevant to a customer-facing Claude application?",
    correctOption: "To reduce the risk of harmful, inappropriate, or policy-violating content reaching end users",
    incorrectOptions: [
      "It mainly matters for internal tooling rather than customer-facing products",
      "It takes the place of writing a system prompt for the assistant",
      "It ensures the model's responses will always be completely error-free"
    ]
  },

  // --- Tools and MCPs ---
  {
    text: "What does MCP stand for in the context of tool integration with Claude?",
    correctOption: "Model Context Protocol",
    incorrectOptions: ["Managed Cloud Platform", "Multi-Client Processing", "Model Configuration Package"]
  },
  {
    text: "What is the purpose of a well-written tool description when defining a function the model can call?",
    correctOption: "To help the model understand when and how to correctly use that tool",
    incorrectOptions: [
      "To serve as end-user documentation without influencing the model's behavior",
      "To add extra token overhead to every request that includes the tool",
      "To keep the tool disabled until an administrator turns it on"
    ]
  },
  {
    text: "What is a benefit of using the Model Context Protocol to expose tools to an AI assistant?",
    correctOption: "It provides a standardized way to connect external tools and data sources across different clients and assistants",
    incorrectOptions: [
      "It is designed to work with only one specific vendor's client",
      "It removes the need to describe a tool's expected parameters",
      "It requires retraining the underlying model to recognize new tools"
    ]
  },
  {
    text: "When a tool call returns an error, what is generally the best way for an agent to handle it?",
    correctOption: "Surface the error back to the model so it can decide how to adapt or retry",
    incorrectOptions: [
      "Suppress the error and continue on as though the call had succeeded",
      "End the current session outright without surfacing what went wrong",
      "Restart the conversation from the beginning and discard the prior context"
    ]
  },

  // --- Applications and Integration (additional) ---
  {
    text: "What is a typical use case for providing image input to the Claude API alongside text?",
    correctOption: "Having the model analyze visual content such as charts, screenshots, or diagrams alongside a text prompt",
    incorrectOptions: [
      "Converting the uploaded images into training data for future fine-tuning",
      "Removing the need to include a system prompt in the request",
      "Cutting the token cost of an image-containing request down to almost nothing"
    ]
  },
  {
    text: "What is the main advantage of using the Files API to upload a document once and reference it by ID in multiple requests?",
    correctOption: "It avoids re-uploading and re-processing the same content on every request, saving bandwidth and often cost",
    incorrectOptions: [
      "It fine-tunes the model on that specific document for future requests",
      "It keeps the document's content out of the model's context window entirely",
      "It automatically translates the document's content into other languages"
    ]
  },
  {
    text: "What is the purpose of a citations feature when Claude answers questions based on provided source documents?",
    correctOption: "To ground the response in specific passages of the source material and let users verify claims against the original text",
    incorrectOptions: [
      "To produce a full summary of the document regardless of what was asked",
      "To let the model answer without the source documents in the prompt",
      "To encrypt the referenced passages so they cannot be read directly"
    ]
  },
  {
    text: "When an application needs Claude to analyze a very long document that approaches the context window limit, what is a reasonable approach?",
    correctOption: "Splitting the document into chunks and processing or summarizing each chunk before combining results",
    incorrectOptions: [
      "Truncating the document at the context limit and hoping little was lost",
      "Raising the temperature parameter so the model compresses the content itself",
      "Switching from asynchronous to synchronous processing for that request"
    ]
  },
  {
    text: "After submitting a large job to the Batch API, how does an application typically retrieve the results?",
    correctOption: "By polling the batch status endpoint (or being notified) until processing completes, then fetching the results",
    incorrectOptions: [
      "Results stream back token by token in real time as they're generated",
      "The application resubmits the batch repeatedly until the job is accepted",
      "Results must be requested from support rather than through the API"
    ]
  },
  {
    text: "What is a benefit of using an official Claude SDK (e.g., for Python or TypeScript) instead of calling the raw HTTP API directly?",
    correctOption: "It provides typed request/response objects, built-in retry logic, and other conveniences that reduce boilerplate",
    incorrectOptions: [
      "It is the sole supported way to authenticate against the API",
      "It handles every error case so the application never needs to",
      "It lowers the number of tokens consumed by each request automatically"
    ]
  },
  {
    text: "What does an HTTP 429 response from the Claude API typically indicate?",
    correctOption: "The client has exceeded a rate limit and should slow down or retry after a delay",
    incorrectOptions: [
      "The request succeeded, and the response is simply being cached",
      "The model declined to respond because of a safety concern",
      "The API key used for the request has been revoked"
    ]
  },
  {
    text: "Why is it good practice to configure a client-side request timeout when calling the Claude API from an application?",
    correctOption: "To avoid the application hanging indefinitely if a response takes unusually long or the connection stalls",
    incorrectOptions: [
      "Every request to the API must specify a timeout value to be accepted",
      "Configuring a timeout expands the context window available to the request",
      "A shorter timeout causes the model to generate its response faster"
    ]
  },
  {
    text: "By default, does the Claude API retain memory of previous requests between separate API calls?",
    correctOption: "No, each request is stateless; the application must include relevant prior context explicitly in the messages",
    incorrectOptions: [
      "Yes, the API keeps a running history of each user's conversation server-side",
      "Yes, but only for accounts on an enterprise-tier plan",
      "No, and the API also discards part of the current request's own history"
    ]
  },
  {
    text: "In a multimodal application, why might a request combine image input with tool use in the same conversation?",
    correctOption: "So the model can visually interpret an image and then take a structured action based on what it observed, such as looking up related data",
    incorrectOptions: [
      "Because images typically need to be sent in a separate request from tool calls",
      "Because pairing an image with a tool call causes the system prompt to be ignored for that particular turn",
      "Because a request must include at least one tool call for images to be accepted"
    ]
  },
  {
    text: "What is a sound resilience practice for a production application if the Claude API becomes temporarily unavailable?",
    correctOption: "Falling back to a degraded experience, such as a cached response or a simplified feature, rather than failing completely",
    incorrectOptions: [
      "Clearing the user's session data so the next attempt starts fresh",
      "Retrying the same request continuously in a fast, unbounded loop",
      "Returning a fabricated success response instead of surfacing the outage"
    ]
  },
  {
    text: "What is a safe way to roll out a significant change to a production prompt or system prompt?",
    correctOption: "Gradually rolling it out to a subset of traffic while monitoring quality metrics before a full rollout",
    incorrectOptions: [
      "Deploying the new prompt to all production traffic on the first release",
      "Adjusting the model's weights directly instead of changing the prompt text",
      "Skipping evaluation, since prompt wording rarely changes model behavior much"
    ]
  },

  // --- Model Selection and Optimization (additional) ---
  {
    text: "What does the temperature parameter primarily control in a Claude API request?",
    correctOption: "The randomness or variability of the model's output, with lower values producing more deterministic responses",
    incorrectOptions: [
      "The maximum number of tokens the model is allowed to generate in its reply",
      "The size of the context window that is available for the request",
      "The price charged for each token processed in the request"
    ]
  },
  {
    text: "What does the max_tokens parameter control in a Claude API request?",
    correctOption: "The maximum length of the model's generated response",
    incorrectOptions: [
      "The maximum size of the input prompt that the request can include",
      "The number of distinct tools the model is permitted to call in a turn",
      "The randomness setting used when sampling the model's next token"
    ]
  },
  {
    text: "Why is it valuable to benchmark candidate models on your own task-specific evaluation set rather than relying solely on public benchmark leaderboards?",
    correctOption: "Public benchmarks may not reflect how a model performs on your application's specific data and requirements",
    incorrectOptions: [
      "Public benchmarks are generally unreliable and not worth factoring into a decision",
      "The API requires a task-specific benchmark to be run before it accepts requests",
      "A model's public benchmark score changes how your application behaves automatically"
    ]
  },
  {
    text: "How can prompt caching and the Batch API be combined to further optimize cost for large-scale, non-urgent workloads?",
    correctOption: "By reusing cached portions of a shared prompt prefix across many batched requests that share common context",
    incorrectOptions: [
      "Prompt caching and the Batch API address separate problems and aren't meant to interact",
      "Using both together roughly doubles the cost compared to using either alone",
      "Submitting a batch request automatically turns off prompt caching for it"
    ]
  },
  {
    text: "When a specific model version is scheduled for deprecation, what should a production application do?",
    correctOption: "Test and migrate to a supported replacement model before the deprecation date to avoid service disruption",
    incorrectOptions: [
      "Nothing in particular, since deprecated models keep working well past their listed date",
      "Switch right away to the cheapest available model without checking task fit",
      "Pause the application and wait to be contacted before making any change"
    ]
  },
  {
    text: "What is a common strategy when the input you need to send regularly exceeds the model's context window?",
    correctOption: "Chunking the input and processing or summarizing it in parts, then combining or iterating on the results",
    incorrectOptions: [
      "Sending the full input as-is and retrying whenever it gets rejected",
      "Lowering the temperature setting so the model responds more concisely",
      "Removing the system prompt from the request to make more room"
    ]
  },
  {
    text: "For a bulk data-processing job with no real-time user waiting, which factor should generally be prioritized over strict low latency?",
    correctOption: "Overall throughput and cost efficiency, since batch or asynchronous processing is more appropriate than optimizing for the fastest single response",
    incorrectOptions: [
      "Minimizing the latency of each individual response, just as with interactive use cases",
      "Throughput has little bearing on which model or processing mode is chosen for a job like this",
      "Cost is a secondary concern compared to raw processing speed for a bulk job like this"
    ]
  },
  {
    text: "What is a relevant consideration when selecting a model for an application that must handle multiple languages well?",
    correctOption: "Evaluating the model's multilingual comprehension and generation quality for the specific languages required",
    incorrectOptions: [
      "Assuming comprehension and generation quality is roughly the same across languages",
      "Treating language support as a minor factor compared to raw model size",
      "Prioritizing the largest available context window over language quality"
    ]
  },
  {
    text: "What is a trade-off of using a 'latest' model alias instead of a specific pinned model version in a production system?",
    correctOption: "It automatically gets improvements over time but risks unexpected behavior changes when the underlying model updates",
    incorrectOptions: [
      "Aliases typically respond more slowly than a specific pinned version",
      "Aliased models cannot be used together with streaming responses",
      "Pinning a specific model version is not something the API allows"
    ]
  },
  {
    text: "What is 'model cascading' (or routing), where a cheap/fast model handles a request first and escalates to a larger model only when needed?",
    correctOption: "A cost-optimization pattern that uses a smaller model as a first pass and falls back to a more capable model only for harder cases",
    incorrectOptions: [
      "A technique for combining two separate models into one merged set of weights",
      "A workflow step that the API enforces on every single request that happens to use tools",
      "A way to work around per-model rate limits by switching between models mid-conversation"
    ]
  },
  {
    text: "How does requesting a longer maximum response length typically affect cost, even if the model does not use all of it?",
    correctOption: "Cost is based on tokens actually generated, so a higher max_tokens limit alone does not increase cost unless more tokens are produced",
    incorrectOptions: [
      "Cost is charged based on the max_tokens value set, not the actual output length",
      "Raising the max_tokens limit tends to lower the price charged for the request's input tokens",
      "The max_tokens setting has essentially no bearing on the request's cost under any configuration"
    ]
  },
  {
    text: "In a pipeline with a simple data-extraction step followed by a complex reasoning step, what is a sound model-selection approach?",
    correctOption: "Using a smaller, faster model for the extraction step and a more capable model for the complex reasoning step",
    incorrectOptions: [
      "Using the most capable model for both steps to keep results consistent",
      "Using the smallest, cheapest model for both steps to minimize overall spend",
      "Switching models at random between the two steps of the pipeline"
    ]
  },

  // --- Prompt and Context Engineering (additional) ---
  {
    text: "Why do many effective Claude prompts use XML-style tags (e.g., <document>, <instructions>) to structure their content?",
    correctOption: "They clearly delineate different sections of the prompt, helping the model distinguish instructions from data",
    incorrectOptions: [
      "The API requires prompts to be wrapped in XML tags to be accepted",
      "Wrapping content in XML tags removes it from the token count entirely",
      "XML tags cause the surrounding text to be translated automatically"
    ]
  },
  {
    text: "What is 'role prompting' in the context of prompt engineering?",
    correctOption: "Assigning the model a specific persona or role (e.g., 'You are an experienced security auditor') to shape its tone and focus",
    incorrectOptions: [
      "Limiting the model so it can only be called through one specific endpoint",
      "A mechanism used purely for authenticating the API key attached to the request",
      "A technique for sending prompts larger than the context window allows"
    ]
  },
  {
    text: "Why is it generally more effective to tell a model what to do rather than only what not to do?",
    correctOption: "Positive instructions give the model a clear target behavior, whereas purely negative instructions can leave the desired behavior ambiguous",
    incorrectOptions: [
      "The model tends to largely ignore instructions that are phrased in the negative form",
      "Positive instructions are generally more token-efficient to write than negative ones are",
      "Prompts containing negative instructions are flagged and rejected by the API"
    ]
  },
  {
    text: "What is 'prefilling' the assistant's response used for in prompt engineering?",
    correctOption: "Starting the model's response with specific text (e.g., an opening brace) to steer it toward a desired format or continuation",
    incorrectOptions: [
      "Authorizing the API key in advance before the request is submitted",
      "Predicting and automatically filling in what the user is likely to type next in the chat",
      "Storing the full conversation history somewhere in a permanent, unremovable cache"
    ]
  },
  {
    text: "What is a trade-off of prompting a model to reason step-by-step (chain-of-thought) before answering?",
    correctOption: "It can improve accuracy on complex tasks but increases token usage and response latency",
    incorrectOptions: [
      "It generally lowers both the cost and the latency of a response",
      "It tends to have little measurable effect on the model's accuracy",
      "It prevents the model from making tool calls during that turn"
    ]
  },
  {
    text: "Why is it helpful to clearly delimit user-supplied or external data from developer instructions within a prompt?",
    correctOption: "It helps the model distinguish trusted instructions from untrusted content, reducing susceptibility to prompt injection",
    incorrectOptions: [
      "Delimiters mainly improve readability without changing how the model behaves",
      "Adding delimiters noticeably lowers the token cost of the request",
      "The API enforces a specific delimiter syntax on every request it accepts"
    ]
  },
  {
    text: "What is a recommended practice when developing a prompt for a production feature?",
    correctOption: "Iteratively testing the prompt against representative examples and refining it based on observed failures",
    incorrectOptions: [
      "Finalizing the prompt after the first draft and moving on to other work",
      "Relying on intuition rather than systematic testing to judge prompt quality",
      "Trying the prompt against one representative example before shipping it"
    ]
  },
  {
    text: "Why might a prompt include an example of an incorrect or undesired output alongside the correct one?",
    correctOption: "To help the model distinguish the desired behavior from a common mistake it should avoid",
    incorrectOptions: [
      "Counter-examples generally have little influence on the model's final output",
      "Adding an incorrect example tends to make the model's output less reliable",
      "It is a common way to work around the content moderation system"
    ]
  },
  {
    text: "In a very long prompt, why does the placement of critical instructions (e.g., near the beginning or end) matter?",
    correctOption: "Models can attend unevenly across a very long context, so placing key instructions prominently reduces the risk they are overlooked",
    incorrectOptions: [
      "The model attends to every part of a long prompt with roughly equal weight",
      "Instructions placed in the middle of a long prompt tend to carry more weight",
      "The API silently reorders the prompt's contents to place instructions in an optimal spot"
    ]
  },
  {
    text: "When using few-shot examples, why is it often better to include a small number of highly relevant examples rather than many loosely related ones?",
    correctOption: "Relevant, well-chosen examples more reliably demonstrate the desired pattern without diluting the model's focus with noise",
    incorrectOptions: [
      "Adding more examples tends to improve output quality even if they're only loosely related",
      "The API caps the number of few-shot examples a single prompt may include",
      "The model automatically screens out and discards irrelevant examples before processing"
    ]
  },
  {
    text: "Why is it useful to explicitly specify the desired tone, style, and length in a prompt for a customer-facing response?",
    correctOption: "It reduces ambiguity and increases the likelihood the output matches brand and format expectations without extra post-processing",
    incorrectOptions: [
      "Tone and style are largely fixed traits of the model that wording can't shift",
      "Specifying a target length generally raises the overall cost of the request",
      "The desired tone is inferred automatically from the account's settings"
    ]
  },
  {
    text: "What is a useful prompting technique to reduce fabricated answers when the required information may not be available in the given context?",
    correctOption: "Explicitly instructing the model to say it does not know or cannot find the answer rather than guessing",
    incorrectOptions: [
      "Raising the temperature so the model explores more creative possibilities",
      "Leaving out instructions entirely so the model can respond however it likes",
      "Trimming the prompt down to a single word to force a terse answer"
    ]
  },

  // --- Agents and Workflows (additional) ---
  {
    text: "What is the 'orchestrator-worker' pattern in agentic workflow design?",
    correctOption: "A lead agent breaks a task into subtasks and delegates them to specialized worker agents, then synthesizes their results",
    incorrectOptions: [
      "A pattern where each agent works independently with no shared coordination",
      "A design constraint limiting an application to exactly one running agent",
      "A technique aimed at minimizing the context window each agent needs"
    ]
  },
  {
    text: "Why might a workflow include a human-in-the-loop checkpoint before an agent performs a high-stakes action?",
    correctOption: "To allow a person to review and approve consequential or irreversible actions before they are executed",
    incorrectOptions: [
      "To add a review step to every action, regardless of how low-risk it is",
      "Because regulations generally require a human to supervise every agent action",
      "To reduce how much of the agent's activity needs to be logged"
    ]
  },
  {
    text: "Why is it generally better to give an agent a small number of clearly distinct tools rather than many overlapping ones?",
    correctOption: "Overlapping tools with similar purposes make it harder for the model to reliably choose the correct one",
    incorrectOptions: [
      "Most agent frameworks cap the number of tools an agent can be given",
      "Adding more tools tends to improve accuracy even when their purposes overlap",
      "The number of available tools rarely influences how well an agent picks between them"
    ]
  },
  {
    text: "In a multi-step agent workflow, how is relevant state typically carried from one step to the next?",
    correctOption: "By explicitly passing relevant results or summaries forward as part of the next step's input or context",
    incorrectOptions: [
      "The model retains relevant state on its own without it being passed forward",
      "Each step in the workflow is designed to be unaware of earlier steps",
      "Relevant state can only be shared through an external database, not the prompt"
    ]
  },
  {
    text: "When a tool call inside an agent loop fails due to a transient error, what is a reasonable design choice?",
    correctOption: "Allow the agent to retry the call, possibly with backoff, or adapt its approach based on the error",
    incorrectOptions: [
      "Shut down the application rather than let the agent continue",
      "Treat the failed call as though it had succeeded and move on",
      "Turn off that tool for the remainder of every future session"
    ]
  },
  {
    text: "Why should an autonomous agent loop have explicit termination conditions, such as a maximum number of steps?",
    correctOption: "To prevent the agent from running indefinitely or looping on a task it cannot complete, controlling cost and risk",
    incorrectOptions: [
      "Termination conditions mostly matter for agents that don't use any tools",
      "Setting an explicit step limit tends to cause the agent to fail right away",
      "Most agent frameworks don't provide a way to cap the number of steps"
    ]
  },
  {
    text: "What is a benefit of having an agent produce an explicit plan before executing actions, rather than acting immediately?",
    correctOption: "It makes the agent's intended approach inspectable and correctable before any actions with real effects are taken",
    incorrectOptions: [
      "Producing a plan first removes the need for the agent to use any tools",
      "Once a plan is produced, it is locked and cannot be revised afterward",
      "Having a plan up front removes the need for a system prompt"
    ]
  },
  {
    text: "What is a practical way to control the cost of a long-running autonomous agent?",
    correctOption: "Setting a maximum number of steps, tool calls, or a token budget the agent cannot exceed",
    incorrectOptions: [
      "Removing the agent's ability to call tools at all during its run",
      "Running the workflow on the most capable and expensive model available",
      "Turning off logging entirely to cut down on runtime overhead"
    ]
  },
  {
    text: "What is the 'evaluator-optimizer' agentic pattern?",
    correctOption: "One agent generates a candidate output while a second agent critiques it, and the process repeats until the output meets quality criteria",
    incorrectOptions: [
      "A single agent produces and grades its own output with no separate reviewer",
      "A cost-tracking feature that automatically lowers API spend without requiring any code changes",
      "A rule requiring every agent involved in a workflow to share an identical prompt"
    ]
  },
  {
    text: "What is the 'routing' pattern in agentic workflow design?",
    correctOption: "Classifying an incoming request and directing it to the most appropriate specialized prompt or agent to handle it",
    incorrectOptions: [
      "Assigning each incoming request to an agent at random for load balancing",
      "A networking concept concerned with directing traffic, not prompts or agents",
      "A pattern where every request is passed through all available agents"
    ]
  },
  {
    text: "When should a developer prefer a fixed, deterministic workflow over a fully autonomous agent?",
    correctOption: "When the steps and decision points of the task are well understood and predictable in advance",
    incorrectOptions: [
      "In most cases, since autonomous agents rarely add value over fixed steps",
      "Rarely, since fixed workflows generally can't be given access to tools",
      "Mainly when the task is simple enough to need no error handling"
    ]
  },
  {
    text: "When a lead agent delegates a subtask to a subagent, what is typically shared with that subagent?",
    correctOption: "A focused subset of context and instructions relevant to the delegated subtask, rather than the entire conversation history",
    incorrectOptions: [
      "Full access to every other subagent's private context and history",
      "Little to nothing; the subagent typically has to infer the task on its own",
      "The lead agent's raw credentials, passed along with the delegated task"
    ]
  },

  // --- Claude Code (additional) ---
  {
    text: "What is the purpose of a CLAUDE.md file in a Claude Code project?",
    correctOption: "To provide persistent, project-specific context and instructions that Claude Code reads at the start of a session",
    incorrectOptions: [
      "To hold the project's compiled build artifacts and binaries",
      "To take the place of the README that end users typically read",
      "To define the project's continuous integration and deployment pipeline configuration"
    ]
  },
  {
    text: "What are custom slash commands in Claude Code used for?",
    correctOption: "Defining reusable shortcuts that expand into a predefined prompt or workflow when invoked",
    incorrectOptions: [
      "Remapping keyboard shortcuts at the operating-system level",
      "Encrypting specific files within the project directory",
      "Taking the place of a version control system for the project"
    ]
  },
  {
    text: "What is the purpose of permission modes in Claude Code, such as requiring approval before running certain commands?",
    correctOption: "To let the user control which actions Claude Code can take autonomously versus which require explicit confirmation",
    incorrectOptions: [
      "To specify which programming languages Claude Code is able to read",
      "To choose the color theme used by the terminal interface",
      "To adjust the temperature parameter used by the underlying model"
    ]
  },
  {
    text: "What is the benefit of using a 'plan mode' in Claude Code before making changes to a codebase?",
    correctOption: "It lets the developer review and approve an intended approach before any code is modified",
    incorrectOptions: [
      "It turns off file editing for the remainder of the session",
      "It pushes the proposed changes straight to production automatically",
      "It removes the need to run tests before merging the change"
    ]
  },
  {
    text: "Why might Claude Code delegate part of a task to a subagent rather than handling everything in the main conversation?",
    correctOption: "To keep a focused task's exploration or tool output isolated, preventing it from cluttering the main conversation's context",
    incorrectOptions: [
      "Subagents in Claude Code are limited to read-only access to files",
      "Delegating work to a subagent turns off git integration for that task",
      "Each subagent that gets spun up needs its own separate billing account to run"
    ]
  },
  {
    text: "What does configuring an MCP server in Claude Code allow the assistant to do?",
    correctOption: "Access additional external tools, services, or data sources beyond its built-in file and shell capabilities",
    incorrectOptions: [
      "Switch which underlying model is used to power the session",
      "Turn off the built-in file and shell tools for the session",
      "Skip the usual permission prompts for every action it takes"
    ]
  },
  {
    text: "How can Claude Code assist with version control tasks such as committing changes or opening a pull request?",
    correctOption: "By running git and platform CLI commands (such as git commit or gh pr create) on the user's behalf, typically with confirmation for risky actions",
    incorrectOptions: [
      "Claude Code has no built-in way to run git commands or interact with GitHub at all",
      "Claude Code pushes every change straight to the main branch without ever asking for confirmation",
      "Claude Code uses its own proprietary system instead of relying on git"
    ]
  },
  {
    text: "Why is it good practice to review the diff of changes Claude Code proposes before accepting them?",
    correctOption: "To catch unintended changes, bugs, or behavior the developer did not intend, since human oversight remains important",
    incorrectOptions: [
      "Diffs are shown mainly for visual reference, not the actual file contents",
      "Reviewing them is optional since AI-proposed changes rarely contain mistakes",
      "Diffs aren't available for changes an AI assistant proposes"
    ]
  },
  {
    text: "Why might a long-running command be executed as a background task in Claude Code rather than blocking the conversation?",
    correctOption: "So the developer can continue interacting with Claude Code while the command completes, and be notified when it finishes",
    incorrectOptions: [
      "Background tasks are moved to a separate, unrelated machine to run",
      "Every command is required to run in the background regardless of length",
      "Background tasks have no way to report their outcome back to the session"
    ]
  },
  {
    text: "What is the purpose of a custom 'skill' in Claude Code?",
    correctOption: "To package a reusable set of instructions or workflow for a recurring type of task so it can be invoked consistently",
    incorrectOptions: [
      "To install a low-level module into the operating system's kernel",
      "To modify the underlying model's training data going forward",
      "To remove the need for any project-specific configuration files"
    ]
  },
  {
    text: "What typically happens as a Claude Code session grows very long and approaches the context window limit?",
    correctOption: "Earlier parts of the conversation may be summarized or compacted so the session can continue without losing essential context",
    incorrectOptions: [
      "The session ends outright and the entire conversation history is lost",
      "The available context window simply expands to accommodate the session",
      "Files edited earlier in the session are automatically rolled back"
    ]
  },
  {
    text: "What is the purpose of configuring an allowlist or denylist of permitted actions in Claude Code's settings?",
    correctOption: "To give the user fine-grained control over which specific commands or tools Claude Code may run automatically versus never or only with approval",
    incorrectOptions: [
      "To control which files are shown or hidden in the file explorer view only",
      "To choose the terminal's color scheme and general visual appearance",
      "To specify which programming language the project is written in"
    ]
  },

  // --- Eval, Testing and Debugging (additional) ---
  {
    text: "What is a 'golden dataset' in the context of evaluating an LLM-powered feature?",
    correctOption: "A curated set of representative inputs paired with expected or high-quality reference outputs used to measure performance",
    incorrectOptions: [
      "A large set of randomly generated inputs with no reference answers attached",
      "The raw training data that was originally used to train the underlying model",
      "A collection made up entirely of examples the model previously failed"
    ]
  },
  {
    text: "Why should a developer re-run an evaluation suite after modifying a production prompt?",
    correctOption: "To check for regressions, ensuring the change did not degrade performance on previously working cases",
    incorrectOptions: [
      "Eval suites are mainly useful once, before the initial prompt is finalized",
      "Small wording changes to a prompt rarely have a measurable effect on behavior",
      "Re-running an eval suite after each change is discouraged as wasteful"
    ]
  },
  {
    text: "Why might an evaluation pipeline use multiple metrics (e.g., exact match, semantic similarity, and human preference) instead of just one?",
    correctOption: "Different metrics capture different aspects of quality, and relying on a single metric can miss important failure modes",
    incorrectOptions: [
      "Most eval pipelines are built to track only a single metric at a time",
      "A well-chosen single metric is usually enough to capture overall quality",
      "Extra metrics are mostly added to make a report look more thorough"
    ]
  },
  {
    text: "What is the purpose of A/B testing two different prompt versions in a production application?",
    correctOption: "To compare their real-world performance on live traffic before fully committing to one version",
    incorrectOptions: [
      "To keep both prompt versions running indefinitely without ever comparing them",
      "To skip offline evaluation entirely and rely on live traffic alone",
      "To find out which version requires fewer API keys to operate"
    ]
  },
  {
    text: "Why is it useful to log an agent's intermediate reasoning and tool calls (its 'trace') during development?",
    correctOption: "It allows developers to understand why the agent made a particular decision and diagnose unexpected behavior",
    incorrectOptions: [
      "Traces are mainly collected for billing and usage-tracking purposes",
      "Recording a trace tends to stop the agent from repeating its mistakes",
      "Detailed traces remove the need to track any evaluation metrics"
    ]
  },
  {
    text: "Since LLM outputs can vary between runs, what is a practical approach to testing behavior reliably?",
    correctOption: "Using a low or zero temperature where appropriate, and/or evaluating multiple samples against defined acceptance criteria",
    incorrectOptions: [
      "Treating LLM features as too unpredictable to test in any systematic way",
      "Setting the temperature to its maximum to focus only on worst-case output",
      "Running the test once and assuming that result is representative"
    ]
  },
  {
    text: "In an LLM-powered application, what might a unit test focus on that an end-to-end integration test would not?",
    correctOption: "Testing individual components in isolation, such as input validation or response-parsing logic, without calling the live model",
    incorrectOptions: [
      "Calling the live production model with real credentials for every test run",
      "Covering roughly the same ground as an end-to-end integration test would",
      "Verifying behavior that can only be checked once the app is fully deployed"
    ]
  },
  {
    text: "Why is it useful to categorize LLM application failures into a taxonomy such as hallucination, refusal, formatting error, and tool misuse?",
    correctOption: "It helps teams identify patterns and prioritize fixes for the most impactful or frequent categories of failure",
    incorrectOptions: [
      "Once a specific bug is found, sorting it into a category adds little value",
      "A single catch-all error category is usually enough for most analysis",
      "This kind of categorization mainly applies to traditional, non-AI software"
    ]
  },
  {
    text: "What is a benefit of running continuous evaluation or monitoring on a live LLM feature, rather than evaluating only before launch?",
    correctOption: "It can catch quality degradation caused by model updates, data drift, or edge cases not seen during initial testing",
    incorrectOptions: [
      "It mostly duplicates work already done during the initial pre-launch testing",
      "It removes the need to run any evaluation before the feature launches",
      "It retrains the underlying model automatically as new data comes in"
    ]
  },
  {
    text: "When an LLM feature produces an unexpected output, what is a sound debugging sequence to follow?",
    correctOption: "Check the exact prompt and inputs sent, verify any tool outputs used, and confirm the model version, before assuming the model itself is at fault",
    incorrectOptions: [
      "Assume the model itself is the problem and switch to a different provider",
      "Treat the output as correct and adjust the UI so the underlying issue isn't visible to users",
      "Clear out the relevant logs so the same issue doesn't keep reappearing later"
    ]
  },
  {
    text: "What kind of test case is important to include when testing an agent that calls external tools?",
    correctOption: "Cases where a tool call fails, returns malformed data, or is called with missing or invalid arguments",
    incorrectOptions: [
      "Cases where every tool call is expected to succeed on the very first try",
      "Cases that avoid tool calls altogether, since those don't need coverage",
      "Cases limited to whichever single tool is the most expensive to run"
    ]
  },
  {
    text: "Why is it important to keep a held-out set of test examples separate from the examples used to iteratively refine a prompt?",
    correctOption: "To avoid overfitting the prompt to the specific examples seen during development, giving a more honest estimate of real-world performance",
    incorrectOptions: [
      "Held-out sets mainly matter in situations where a model's weights are being fine-tuned",
      "Reusing the same examples for both development and evaluation tends to be more accurate",
      "The API requires a held-out set to be defined before it will accept any requests at all"
    ]
  },

  // --- Security and Safety (additional) ---
  {
    text: "What is 'indirect prompt injection'?",
    correctOption: "Malicious instructions embedded in external content (such as a webpage, email, or document) that an agent processes and may inadvertently follow",
    incorrectOptions: [
      "A user directly typing malicious commands straight into the chat interface",
      "A technique aimed specifically at making prompt processing run more quickly overall",
      "An officially documented and fully supported way for developers to configure model behavior"
    ]
  },
  {
    text: "Why is it particularly risky to give an agent both access to sensitive internal data and the ability to make outbound network requests?",
    correctOption: "A compromised or manipulated agent could be tricked into leaking sensitive data to an external destination",
    incorrectOptions: [
      "A well-written system prompt is generally enough to remove that risk",
      "Outbound network requests are typically blocked by default for any agent",
      "Most agent frameworks prevent an agent from having both kinds of access at once"
    ]
  },
  {
    text: "Before executing a shell command or code snippet suggested by an agent, what is a reasonable safeguard?",
    correctOption: "Validating or reviewing the command for safety and correctness, especially for actions with real-world side effects",
    incorrectOptions: [
      "Running it right away without review, since agent-suggested commands are usually safe",
      "Removing shell access from every agent regardless of the task",
      "Reviewing only the shortest commands, since longer ones are rarely risky"
    ]
  },
  {
    text: "Why should an application use scoped, least-privilege API keys or credentials for a Claude-powered feature rather than broad administrative credentials?",
    correctOption: "To limit the potential damage if the key is leaked or the feature is misused",
    incorrectOptions: [
      "Scoped keys tend to return faster responses than broader credentials",
      "Every Claude API call needs broad administrative credentials to succeed",
      "Limiting a key's scope has little practical effect on overall security"
    ]
  },
  {
    text: "What is a common way to restrict a customer-facing assistant from discussing off-topic or disallowed subjects?",
    correctOption: "Including explicit guardrail instructions in the system prompt, combined with output monitoring",
    incorrectOptions: [
      "Retraining the underlying model is the only way to add this kind of guardrail",
      "A deployed assistant's allowed topics generally can't be constrained after launch",
      "This kind of restriction is implemented at the hardware level, not in software"
    ]
  },
  {
    text: "Why should code generated or executed by an autonomous agent typically run in a sandboxed environment?",
    correctOption: "To contain any unintended or malicious behavior and limit the code's access to the broader system",
    incorrectOptions: [
      "Sandboxing mainly matters for human-written code rather than AI-generated code",
      "Running code in a sandbox helps confirm that it behaves correctly",
      "Sandboxes mostly add execution overhead without a meaningful security benefit"
    ]
  },
  {
    text: "What is an important security consideration before connecting an agent to a third-party MCP server?",
    correctOption: "Reviewing the trustworthiness and permissions of the server, since it can expose powerful tools and data access to the agent",
    incorrectOptions: [
      "Trusting that the protocol itself vets and secures every server automatically",
      "Assuming an MCP server has no way to reach external systems by design",
      "Treating a third-party server the same as one you run and control locally"
    ]
  },
  {
    text: "Why should a customer-facing AI feature implement its own rate limiting or abuse detection in addition to the API's own limits?",
    correctOption: "To prevent a small number of users from overwhelming the feature or driving excessive cost through abusive usage patterns",
    incorrectOptions: [
      "The API's own rate limits are generally sufficient without extra controls",
      "Adding rate limiting tends to reduce the quality of the responses returned",
      "Abuse detection is mainly a concern for traditional, non-AI features"
    ]
  },
  {
    text: "Why is it important to maintain an audit log of actions an autonomous agent takes in a production system?",
    correctOption: "To provide accountability and a way to trace back what the agent did if something goes wrong",
    incorrectOptions: [
      "Audit logs are mainly compiled for marketing and reporting purposes",
      "Recording an agent's actions this way is generally discouraged for AI systems",
      "Keeping an audit log removes the need for any other kind of safeguard"
    ]
  },
  {
    text: "What is the purpose of red-teaming an LLM-powered application before it launches?",
    correctOption: "To proactively probe the system with adversarial inputs to find safety, security, or misuse vulnerabilities before real users encounter them",
    incorrectOptions: [
      "To showcase the product to a panel of external reviewers before launch",
      "To focus specifically on measuring the application's response latency under load",
      "To take the place of the application's regular functional test suite entirely"
    ]
  },
  {
    text: "Why should an autonomous agent typically require explicit human approval before performing an irreversible action, such as permanently deleting production data?",
    correctOption: "Because such actions cannot be undone if the agent misjudges the situation, making the cost of an error especially high",
    incorrectOptions: [
      "An agent acting alone is generally just as safe for irreversible actions",
      "Human approval mainly matters for actions that are easy to undo anyway",
      "Most agent frameworks prevent an agent from taking irreversible actions at all"
    ]
  },
  {
    text: "When an agent processes content retrieved from a tool call or an external document, how should that content generally be treated?",
    correctOption: "As untrusted data that should not be blindly followed as instructions, since it could contain injected commands",
    incorrectOptions: [
      "As trusted content carrying the same authority as the system prompt",
      "As output that should be acted on right away without a closer look",
      "As background noise that has no bearing on the agent's next action"
    ]
  },

  // --- Tools and MCPs (additional) ---
  {
    text: "What is the purpose of defining a tool's parameters using a JSON schema when registering it for model use?",
    correctOption: "To specify the expected structure and types of arguments so the model can generate valid, well-formed tool calls",
    incorrectOptions: [
      "To encrypt the underlying implementation code behind the tool",
      "To assign the tool to a particular pricing or billing tier",
      "To restrict use of the tool to administrator accounts only"
    ]
  },
  {
    text: "In the Model Context Protocol, what is the general relationship between an MCP server and an MCP client?",
    correctOption: "The server exposes tools, resources, or prompts, while the client (such as an AI assistant application) connects to and consumes them",
    incorrectOptions: [
      "The client and the server typically run together as a single combined process",
      "The server functions as an AI model while the client acts as a database",
      "Each MCP server is generally tied to one specific, hardcoded client application"
    ]
  },
  {
    text: "In MCP, what is the general distinction between a 'resource' and a 'tool'?",
    correctOption: "A resource typically exposes readable data or context, while a tool exposes an action the model can invoke",
    incorrectOptions: [
      "Resources and tools describe essentially the same concept under different names",
      "Resources are used mainly for billing purposes, while tools handle logging",
      "Tools mainly expose data for reading, while resources trigger actions"
    ]
  },
  {
    text: "What problem can arise from registering multiple tools with very similar names and unclear descriptions?",
    correctOption: "The model may struggle to choose the correct tool, leading to incorrect or inconsistent tool calls",
    incorrectOptions: [
      "The client automatically merges similarly named tools before exposing them",
      "Having overlapping tool names tends to make the model's choices more accurate",
      "Most tool registries prevent similarly named tools from being defined at all"
    ]
  },
  {
    text: "What is a key difference between a local MCP server and a remote MCP server?",
    correctOption: "A local server typically runs on the same machine as the client, while a remote server is accessed over a network, often requiring authentication",
    incorrectOptions: [
      "Local servers are generally limited to exposing resources rather than any callable tools",
      "The Model Context Protocol only defines support for locally running servers",
      "The distinction is mostly cosmetic, with no real difference in how they behave"
    ]
  },
  {
    text: "Why should a tool's result be returned in a concise, well-structured format rather than an overly verbose one?",
    correctOption: "To avoid wasting context window space and tokens, keeping the model focused on relevant information",
    incorrectOptions: [
      "Longer, more detailed tool results tend to make the model more accurate",
      "Tool results are kept separate and never actually enter the model's context",
      "Keeping results concise mainly matters for how usage is billed"
    ]
  },
  {
    text: "Why is it important to version a tool's schema as it evolves over time?",
    correctOption: "To avoid breaking existing integrations or agents that rely on the previous schema when parameters change",
    incorrectOptions: [
      "A tool's schema is generally fixed permanently once it's first published",
      "Tracking schema versions has little to do with backward compatibility",
      "It's enough to track the model's version without tracking the tool's"
    ]
  },
  {
    text: "What does it mean when a model is capable of making 'parallel tool calls' in a single turn?",
    correctOption: "It can request multiple independent tool invocations at once instead of only one at a time, potentially reducing round trips",
    incorrectOptions: [
      "It limits the model to making just one tool call across the whole conversation",
      "It means several different AI models execute the tool calls simultaneously",
      "It describes repeating an identical tool call twice purely for redundancy"
    ]
  },
  {
    text: "What is the purpose of the 'prompts' feature that an MCP server can expose, in addition to tools and resources?",
    correctOption: "To provide reusable, parameterized prompt templates that clients can surface to users or the model",
    incorrectOptions: [
      "To store a copy of the underlying model's private weights",
      "To remove the need for the client to define a system prompt at all",
      "To take the place of defining any tools for the server to expose"
    ]
  },
  {
    text: "Why is authentication typically required when connecting to a remote MCP server?",
    correctOption: "To ensure only authorized clients can access the tools and data the server exposes, which may be sensitive",
    incorrectOptions: [
      "Remote services of this kind generally don't need any authentication step",
      "Remote MCP servers typically expose only tools with nothing sensitive to protect",
      "This kind of authentication mainly applies to servers running locally, not remotely"
    ]
  },
  {
    text: "Why should an application validate the arguments in a model-generated tool call before executing the underlying action?",
    correctOption: "Because the model can occasionally produce malformed, incomplete, or unexpected arguments that could cause errors or unsafe behavior if executed blindly",
    incorrectOptions: [
      "Model-generated arguments are reliable enough that validation rarely catches anything",
      "Validation mainly matters for read-only tools that never modify any underlying application data",
      "Adding argument validation runs counter to how the Model Context Protocol is meant to be used"
    ]
  },
  {
    text: "What is the benefit of an MCP client being able to dynamically discover the list of tools and resources a server currently exposes?",
    correctOption: "It allows the client to adapt to servers whose available capabilities may change, without requiring hardcoded knowledge in advance",
    incorrectOptions: [
      "This kind of discovery has been deprecated and dropped from the protocol",
      "The client generally needs to be rebuilt whenever the server's tools change",
      "It removes the need to define a schema for any of the tools the server exposes"
    ]
  }
];
