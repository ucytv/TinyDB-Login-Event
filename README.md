## TinyDB-Login-Event

Thanks to the TinyDB class using SharedPreferences methods, you can easily skip the login screen. All you have to do add the TinyDB class and Gson library to your project. After that, you can save and delete your data with just two lines of code. The demo and source codes of project are shown following. Also, you can click the link for details of login screen design: [Login-Design-3](https://github.com/ucytv/Login-Design-3)

### Demo

![tinydb_app](https://user-images.githubusercontent.com/37077627/82721471-f8824a00-9cc5-11ea-81ae-a4308fe2783c.png)

### Using

* Download **TinyDB class** and add your project
  - [TinyDB Class](https://github.com/ucytv/TinyDB-Login-Event/blob/master/app/src/main/java/com/ucy/tinydbapp/TinyDB.java)
  
* Add *Gson library* to build.gradle *(app)* 
  
  ```
  implementation 'com.google.code.gson:gson:2.8.5'
  ```

* Create a TinyDB object on your activity
  ```
  private TinyDB tinyDB;
  tinyDB = new TinyDB(MainActivity.this);
  ```
  
* Save your data with *put()* method
  ```
  tinyDB.putString("pass", passInfo);
  ```
  
* Retrieve your data with *get()* method
  ```
  tinyDB.getString("pass");
  ```
 
* Skip the login screen
 
* Use the *clear()* method to delete your saved data
  
  ```
  tinyDB.clear();
  ```

