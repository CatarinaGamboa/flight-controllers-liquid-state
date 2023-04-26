# Repos that use mavsdk Java

Idea for Evaluation: 
1. Look for the library (e.g. "io.mavsdk.camera.Camera") in github code with Java language
2. Take 2 examples from the first page of github to use it
- exclude: if the lib is only in imports (no invocations to the class methods)
3. Change to synchronous
4. Test with LiquidJava

### Mission
[androind-client](https://github.com/jankrystianserafim/android-client/blob/d622b16126c2421dcff27e1be0d59c22deaab349/app/src/main/java/io/mavsdk/androidclient/MapsViewModel.java)
uses Mission but is asynchronous
[android](https://github.com/KINGPEYTON/mavlink-test/blob/b8b9704d12cc162a5591f8b70ca5395c6824586b/app/src/main/java/io/mavsdk/androidclient/MapsViewModel.java)
similar to previous one

### Camera

[run camera]([https://github.com/mavlink/MAVSDK-Java/blob/d4f9b6d5ef60d01423ee2d47ea6fa4892065efae/examples/java-client/src/main/java/io/mavsdk/example/RunCamera.java#L4](https://github.com/mavlink/MAVSDK-Java/blob/d4f9b6d5ef60d01423ee2d47ea6fa4892065efae/examples/java-client/src/main/java/io/mavsdk/example/RunCamera.java#L4)
[list photos](https://github.com/mavlink/MAVSDK-Java/blob/d4f9b6d5ef60d01423ee2d47ea6fa4892065efae/examples/java-client/src/main/java/io/mavsdk/example/ListPhotos.java#L4)

### FollowMe

### Geofence

### Offboard
[drone-attacks](https://github.com/VUISIS/drone-attacks/blob/aa92f3462aebe1be86bb81b31907f939d0f388ee/Java/src/main/java/edu/cmu/demo/utils/DroneAction.java#L10)
[simon](https://github.com/sychoo/CPS-weakening-based-resolution/blob/d0c61d94fd57f8404e0386c90b3e93fbfdfccc7e/px4-experiments/src/main/java/edu/cmu/px4/mavsdk/examples/OffboardExample.java#L9)
[cps-awakening](https://github.com/sychoo/CPS-weakening-based-resolution/blob/d0c61d94fd57f8404e0386c90b3e93fbfdfccc7e/px4-experiments/src/main/java/edu/cmu/px4/mavsdk/examples/ChangeHeadingVelocityNed.java#L11)
