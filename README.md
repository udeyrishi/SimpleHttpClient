# SimpleHttpClient

![](https://raw.githubusercontent.com/udeyrishi/SimpleHttpClient/master/logo.png)

SimpleHttpClient is a simple HTTP client wrapper around the [HttpUrlConnection](https://docs.oracle.com/javase/7/docs/api/java/net/HttpURLConnection.html) API for making HTTP requests. It's intended to provide a simple and quick way of performing the most popular kinds of HTTP requests, as HttpUrlConnection provides unnecessary complication for doing simple stuff.

This project is made with Android in mind, especially because Apache's HttpClient is now [not supported starting API 23](http://developer.android.com/intl/zh-tw/about/versions/marshmallow/android-6.0-changes.html). Nevertheless, this is a regular Java project that is compatible with non-Android environments as well.

It contains the simplest set of operations that I commonly use in other projects, and is intended to be a continuously growing project for supporting other features.

### Building & Testing

This is a Maven project, and should be compatible with popular IDEs like IntelliJ IDEA or Eclipse. The test suite uses JUnit4.

### Usage & Documentation

A compiled .jar is kept in the /bin directory for direct importing. The usage documentation is present in the project as Javadocs in the /javadocs directory. See a project using this library [here](https://github.com/udeyrishi/AndroidElasticSearchDataManager).

### License

[Apache v2.0](https://github.com/udeyrishi/SimpleHttpClient/blob/master/LICENSE)
