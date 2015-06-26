**Projects:**
  * **buildtools:** Various maven mojos and ant targets to assist in using various APIs.
  * **[modeldata](modeldata.md):** Annotation used by _buildtools_ to mark classes to be processed to generate GXT ModelData implementations from existing POJOs.
  * **UnittWebSocketClient:** Objective-C WebSocket client implementation for iOS. It should work on MacOSX as well, but only tested on iOS (compatible with RFC6455, rev00, rev07, rev08, rev10). Passes all Autobahn RFC6455 compliance tests.
  * **[UnittJSONSerializer](http://unitt.googlecode.com/svn/projects/iOS/UnittJSONSerializer/trunk/):** Objective-C library for iOS that binds JSON to Objective-C objects. Allows developers to work with their native classes and still communicate with JSON services. Automatically detects Objective-C class and creates it from the JSON or vice-versa. This library is currently in sandbox mode. The API will change (needs cleanup and documentation). It should settle down in the next few weeks. It is already being used internally in several projects, so I just need to eliminate old, obsolete class detection/suggestion mechanics from the API and finish the automated tests. It should work on MacOSX as well, but only tested on iOS.
  * **[Unitt-WebSocket](UnittWebSocket.md):**Java/Android WebSocket client/server implementation for rev07, rev08, rev10. This is working with pure sockets and will provide support for client and server hooks to common frameworks such as Netty, Grizzly, etc. There is a functioning Java IO client that works with proxies and SSL. The Java NIO (using Netty) client does not yet support SSL or proxies (easy to add your own using Netty). This should be addressed shortly. Now supports all versions of Android!
  * **[UnittUIWidgets](UnittUIWidgets.md):** UnittUIWidgets is a library of widgets that you can use in your iOS projects