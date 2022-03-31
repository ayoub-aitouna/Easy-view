# Easy-view

SAGE
-----

to make drawable shape without needing to make drawable file in your layout XML and add EasyView library in your project or you can also grab it via Gradle:

```groovy

implementation 'implementation 'com.github.jrayoub:Easy-view:1.0.0''



repositories {
			...
			maven { url 'https://jitpack.io' }
		}
```

XML
-----
TextView With Gradient Colors
```xml
 <project.savvycom.mylibrary.MyViews.GradientText
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:text="Hello World!"
        android:textSize="21sp"
        android:textStyle="bold"
        app:angle="45"
        app:endColor="@color/purple_500"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:startColor="@color/teal_700" />

```
Easy modifiable View
```xml
  <project.savvycom.mylibrary.MyViews.MyView
        android:layout_width="150dp"
        android:layout_height="150dp"
        android:layout_gravity="center"
        android:layout_marginTop="50dp"
        android:orientation="vertical"
        android:paddingHorizontal="10dp"
        app:MyView_radiusBottomRight="150"
        app:MyView_radiusTopLeft="150"
        custom:MyView_angle="-180"
        custom:MyView_color="#000000"
        custom:MyView_endColor="#00BCD4"
        custom:MyView_radius="50"
        custom:MyView_startColor="#2196F3" />
```
```xml
<project.savvycom.mylibrary.MyViews.MyLinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:custom="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="top"
    android:orientation="vertical"
    android:paddingHorizontal="10dp"
    android:paddingTop="30dp"
    custom:MyView_angle="-90"
    custom:MyView_color="#000000"
    custom:MyView_endColor="#FF8F71"
    custom:MyView_radius="5"
    custom:MyView_startColor="#EF2D1A"
    tools:context=".MainActivity">
  
    <!-- ... -->
  </project.savvycom.mylibrary.MyViews.MyLinearLayout>
```
