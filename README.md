# Room Database Demo
 This is a demo app on how to implement Room persistance library, making use of LiveData in Android app
 
# Key Points of Room Database:

* Room is a part of android architecture components.
* Room is a database layer on top of Sqlite Database
* Room Database helps us to verify the sql queries at compile time instead of run Tim as a results there would be no risk of     runtime error that might crash the app.
* Room DB helps us to reduce the boilerplate code and improves the code readability.
* To represent Room Database we need to create abstract class which extends Room Database.
* To represent each table we should use Entity class
* To communicate with database we need to create Data Access Objects (DAOs)

 
 ## Dependencies

```
def material_designs_version = "1.0.0"
def room_version = "2.1.0"


// Material Designs
implementation "com.google.android.material:material:$material_designs_version"


// Room Library
implementation "androidx.room:room-runtime:$room_version"
kapt "androidx.room:room-compiler:$room_version"
```
# Demo
 
  <td>
    <p align="left">
  <img src="https://user-images.githubusercontent.com/10658016/66370334-70ad3100-e9bd-11e9-8573-40a3cca32dac.gif?raw=true" alt="Home Page" width="300"/>
</p>
