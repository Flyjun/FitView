# FitView
分辨率适配FitView

在开发中，ui给我们的是px单位的值，那么我们常常需要转换，现在开发出FitView，可以和ui的值对应上了，我们不用再担心具体是多少了。
FitView支持的设置的属性：

                        textSize

			padding
			paddingLeft
			paddingTop
			paddingRight
			paddingBottom

			layout_width
			layout_height
			
			layout_margin
			layout_marginLeft
			layout_marginTop
			layout_marginRight
			layout_marginBottom

FitView的使用

demo中设计的基准是1080*1920，开发的时候可以根据ui图的设计来设置

支持横竖屏（横竖屏设置时需要把值写在values/dimens，values-land/dimens）

1、直接引用根布局

   <?xml version="1.0" encoding="utf-8"?>
<com.flyjun.fitview.FixLinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    >

    <TextView
        android:text="Hello World!"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/textView"
        android:textSize="@dimen/text"/>

    <Button
        android:layout_width="@dimen/width"
        android:layout_height="wrap_content"
        android:text="New Button"
        android:id="@+id/button"
        android:textSize="@dimen/text"
        android:layout_gravity="center_horizontal"

        />

    <ImageView
        android:layout_width="200px"
        android:layout_height="200px"
        android:id="@+id/imageView"
        android:src="@mipmap/ic_launcher"
        android:layout_marginTop="20px"
        android:layout_marginLeft="20px"/>

</com.flyjun.fitview.FixLinearLayout>


2、动态创建的view也可以使用

   FitHelper.on(v).setWidth(200).setTextSize(50).builder();
   
   
3、获取一个值

  float w=FitHelper.getFitWidth(this,80);

   
