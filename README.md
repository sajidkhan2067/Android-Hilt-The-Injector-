# Hilt-the-injector
Hilt into Jetpack Compose.

Hilt, a powerful dependency injection (DI) framework rooted in Dagger, 
eases the transition for developers already familiar with Dagger in Android app development. 
It streamlines the process of dependency resolution by automating the heavy lifting, reducing manual work, and ensuring compile-time correctness. 
One of Hilt's core strengths is its ability to intelligently manage class interdependencies, creating a robust and well-organized dependency graph. 
This early error detection during compilation is invaluable, preventing issues that might otherwise disrupt the app's runtime. 
Hilt is not just a time-saver; it's a tool that enhances the testing process by automatically placing the correct mocks for unit and UI tests, ensuring the app's stability.

Integrating Hilt into an Android project is straightforward. 
It necessitates creating an Application class that inherits from the standard Android Application class and annotating it with 
@HiltAndroidApp. This simple setup ensures that all components in the app become lifecycle-aware.
Hilt offers two primary methods of dependency injection: constructor and field injection. 
Constructor injection is used for passing dependencies through class constructors, 
while field injection is handy for Android classes like Activity and Fragment, 
where Hilt takes control of injecting dependencies automatically. 
In both cases, Hilt modules and bindings are employed to define and specify where the app's dependencies are located. 
By generalizing classes into abstract classes or interfaces, 
developers can facilitate the creation of mocks or interchange multiple instances of the same class, providing flexibility and making the app more maintainable. 
In summary, Hilt is a powerful tool for Android app development, making DI more accessible and helping developers create clean, testable, and robust code.

This project demonstrates the usage of Hilt in conjunction with navigation and Jetpack Compose, providing a practical example. 
Detailed explanations with comments are provided within each file to help you understand the code.


References:

1. https://developer.android.com/training/dependency-injection/hilt-android
2. https://github.com/philipplackner/DaggerHiltCourse
3. https://www.geeksforgeeks.org/dagger-hilt-in-android-with-example/
4. https://medium.com/@tomas-repcik/dependency-injection-with-hilt-in-android-development-e23fc636d65c
