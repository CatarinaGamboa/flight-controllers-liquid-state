# Evaluation
Process:
1. Search in Github Code for the library name
2. Select 2 examples from the 1st page of results
   1. The code example needs to use the methods in the library, imports only will be discarded
3. Change the code to be synchronous
4. Test with LiquidJava



# Examples

### Mission
keyword: `io.mavsdk.mission.Mission`

#### Examples:
[androind-client](https://github.com/jankrystianserafim/android-client/blob/d622b16126c2421dcff27e1be0d59c22deaab349/app/src/main/java/io/mavsdk/androidclient/MapsViewModel.java) -
uses Mission but is asynchronous

[android](https://github.com/KINGPEYTON/mavlink-test/blob/b8b9704d12cc162a5591f8b70ca5395c6824586b/app/src/main/java/io/mavsdk/androidclient/MapsViewModel.java) -
similar to previous one

#### Chosen to model:
1.  https://github.com/mavlink/MAVSDK-Java/tree/main/examples/java-client/src/main/java/io/mavsdk/example

2. -

### Camera
keyword: `io.mavsdk.camera.Camera`

#### Examples:
[run camera](https://github.com/mavlink/MAVSDK-Java/blob/d4f9b6d5ef60d01423ee2d47ea6fa4892065efae/examples/java-client/src/main/java/io/mavsdk/example/RunCamera.java#L4)

[run camera2](https://github.com/mavlink/MAVSDK-Java/blob/d4f9b6d5ef60d01423ee2d47ea6fa4892065efae/examples/java-client/src/main/java/io/mavsdk/example/RunCamera.java#L4)


[list photos](https://github.com/mavlink/MAVSDK-Java/blob/d4f9b6d5ef60d01423ee2d47ea6fa4892065efae/examples/java-client/src/main/java/io/mavsdk/example/ListPhotos.java#L4)

#### Chosen to model:
1. https://github.com/mavlink/MAVSDK-Java/tree/main/examples/java-client/src/main/java/io/mavsdk/example

2. -


### FollowMe
keyword: `io.mavsdk.follow_me.FollowMe`

#### Examples:

#### Chosen to model:
1. -
2. -

### Ftp
keyword: `io.mavsdk.ftp.Ftp`

#### Examples:

#### Chosen to model:
1. -
2. -


### Geofence
keyword: `io.mavsdk.geofence.Geofence`

#### Examples:

#### Chosen to model:
1. -
2. -


### Mocap
keyword: `io.mavsdk.mocap.Mocap`

#### Examples:

#### Chosen to model:
1. -
2. -

### Offboard
keyword: `io.mavsdk.offboard.Offboard`

#### Examples:
[drone-attacks](https://github.com/VUISIS/drone-attacks/blob/aa92f3462aebe1be86bb81b31907f939d0f388ee/Java/src/main/java/edu/cmu/demo/utils/DroneAction.java#L10)

[simon](https://github.com/sychoo/CPS-weakening-based-resolution/blob/d0c61d94fd57f8404e0386c90b3e93fbfdfccc7e/px4-experiments/src/main/java/edu/cmu/px4/mavsdk/examples/OffboardExample.java#L9)

[cps-awakening](https://github.com/sychoo/CPS-weakening-based-resolution/blob/d0c61d94fd57f8404e0386c90b3e93fbfdfccc7e/px4-experiments/src/main/java/edu/cmu/px4/mavsdk/examples/ChangeHeadingVelocityNed.java#L11)

#### Chosen to model:
1. -
2. -