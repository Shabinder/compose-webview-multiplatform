package com.multiplatform.webview.web

/**
 * Created By Kevin Zou On 2023/9/5
 */
/**
 * Interface for WebView
 */
interface IWebView {
    /**
     * True when the web view is able to navigate backwards, false otherwise.
     */
    fun canGoBack(): Boolean

    /**
     * True when the web view is able to navigate forwards, false otherwise.
     */
    fun canGoForward(): Boolean

    /**
     * Loads the given URL.
     *
     * @param url The URL of the resource to load.
     */
    fun loadUrl(url: String, additionalHttpHeaders: Map<String, String> = emptyMap())

    /**
     * Loads the given HTML string.
     *
     * @param html The HTML string to load.
     * @param baseUrl The URL to use as the page's base URL.
     * @param mimeType The MIME type of the data in the string.
     * @param encoding The encoding of the data in the string.
     * @param historyUrl The history URL for the loaded HTML. Leave null to use about:blank.
     */
    fun loadHtml(
        html: String? = null,
        baseUrl: String? = null,
        mimeType: String? = "text/html",
        encoding: String? = "utf-8",
        historyUrl: String? = null
    )

    /**
     * Posts the given data to the given URL.
     *
     * @param url The URL to post the data to.
     * @param postData The data to post.
     */
    fun postUrl(
        url: String,
        postData: ByteArray
    )

    /**
     * Navigates the webview back to the previous page.
     */
    fun goBack()

    /**
     * Navigates the webview forward after going back from a page.
     */
    fun goForward()

    /**
     * Reloads the current page in the webview.
     */
    fun reload()

    /**
     * Stops the current page load (if one is loading).
     */
    fun stopLoading()

    /**
     * Evaluates the given JavaScript in the context of the currently displayed page.
     * and returns the result of the evaluation.
     * Note: The callback will not be called from desktop platform because it is not supported by CEF currently.
     */
    fun evaluateJavaScript(script: String, callback: ((String) -> Unit)? = null)
}