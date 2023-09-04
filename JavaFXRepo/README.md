# https://www.youtube.com/watch?v=nz8P528uGjk

# Right click project go to run-as configurations.

* Go to arguments, paste this:
```
--module-path "H:\ProgramFiles\eclipse\openjfx-20.0.2_windows-x64_bin-sdk\javafx-sdk-20.0.2\lib" --add-modules javafx.controls,javafx.graphics,javafx.fxml
```

* Go to dependencies, move JavaFX to ModulePath Entries and out of classpath. 
* Simply click on Modulepath Entries then go to advanced and use "Add library" -> User Library -> JavaFX

* In the future I'll have to add pictures to my README(s).
