package com.flyjun.fitview;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 分辨率适配帮助类
 * @author Flyjun
 *
 */
public class FitHelper {

	private static Context context;
	
	public int width; //屏幕的宽度
	public int height; //屏幕的高度
	

	public float designWidth=1080.0f; //设计屏幕的宽度
	public float designHeight=1920.0f; //设计屏幕的高度
	

	/**
	 * 保存AttributeSet集合
	 */
	public static List<FitAttributeSet> fitAttrsList;
	
	/**
	 * 适配支持的属性
	 */
	private static final int[] designAttrs = new int[] {
		
		    android.R.attr.textSize,// 0

			android.R.attr.padding,// 1
			android.R.attr.paddingLeft,// 2
			android.R.attr.paddingTop,// 3
			android.R.attr.paddingRight,// 4
			android.R.attr.paddingBottom,// 5

			android.R.attr.layout_width,// 6
			android.R.attr.layout_height,// 7
			
			android.R.attr.layout_margin,// 8
			android.R.attr.layout_marginLeft,// 9
			android.R.attr.layout_marginTop,// 10
			android.R.attr.layout_marginRight,// 11
			android.R.attr.layout_marginBottom,// 12

	};
	
	private static final String WRAP_CONTENT = "-2";
    private static final String MATCH_PARENT = "-1";
    
    private static final int TEXT_SIZE = 0;
	 
	private static final int PADDING = 1;
	private static final int PADDING_LEFT = 2;
	private static final int PADDING_TOP = 3;
	private static final int PADDING_RIGHT = 4;
	private static final int PADDING_BOTTOM = 5;
	
	private static final int WIDTH = 6;
	private static final int HEIGHT = 7;

	private static final int MARGIN = 8;
	private static final int MARGIN_LEFT = 9;
	private static final int MARGIN_TOP = 10;
	private static final int MARGIN_RIGHT = 11;
	private static final int MARGIN_BOTTOM = 12;
	
	
	private static FitHelper instance;
	private static View dynamicView;
	
	private static FitHelper getInstance(){
		if(null == instance){
			instance=new FitHelper();
		}
		return instance;
	}
	
	
	/**
	 * instance用于代码调用
	 * FitHelper.on(tb).setWidth(650).setTextSize(65).builder();
	 * 调用builder才会生效
	 */
	public static Builder on(View view){
		dynamicView=view;
		getInstance().init(view.getContext());
		return new Builder();
	}
	
	/**
	 * 获取一个分辨率计算的宽度值
	 * @param context
	 * @param width
	 * @return
	 */
	public static float getFitWidth(Context context,float width){
		getInstance().init(context);
		return getInstance().getWidthSize(width);
	}
	
	/**
	 * 获取一个分辨率计算的高度值
	 * @param context
	 * @param height
	 * @return
	 */
	public static float getFitHeight(Context context,float height){
		getInstance().init(context);
		return getInstance().getHeightSize(height);
	}
	
	/**
	 * 用于复写组件创建实例
	 * @param context
	 * @return
	 */
	public static FitHelper newInstance(Context context){
		
		FitHelper fitHelper =new FitHelper();
		fitHelper.init(context);
		fitHelper.initAttrsList();
		
		return fitHelper;
	}
	
	/**
	 * 设置view的参数
	 * @param view
	 * @param attrs
	 */
	public void setViews(View view,FitAttributeSet attrs){
		setAttrs(view,attrs);
	}
	
	/**
	 * 获取view的AttributeSet
	 * @param fitHelper
	 * @param attrs
	 */
	public void setViewAttr(FitHelper fitHelper, AttributeSet attrs){
		if(null != attrs){
			fitHelper.getAttrs(attrs);
		}
	}
	
	
	public void init(Context context) {
		// TODO Auto-generated constructor stub
		this.context=context;
		this.getWidthAndHeight();
	}
	
	public void initAttrsList(){
		fitAttrsList =new ArrayList<FitAttributeSet>();
	}
	
	/**
	 * 获取屏幕的大小
	 */
	private void getWidthAndHeight(){
		DisplayMetrics dm = new DisplayMetrics();  
		dm = context.getResources().getDisplayMetrics(); 
		width=dm.widthPixels;
		height=dm.heightPixels;
	}
	

	/**
	 * 获取AttributeSet的值
	 * @param attrs
	 */
	public void getAttrs(AttributeSet attrs){

		 TypedArray typedArray = context.obtainStyledAttributes(attrs, designAttrs);
		 
		 FitAttributeSet fitAttrs=new FitAttributeSet();
		 
		 for (int i = 0; i < typedArray.getIndexCount(); i++) {
			 
			 int index=typedArray.getIndex(i);
				 
			 /**
			  * 判断是不是px为单位的值
			  */
				 if (!isPxVal(typedArray.peekValue(index))){ 
					 continue;
				 }
				 
			
			switch (index) {

			case TEXT_SIZE:
				fitAttrs.setTextSize(typedArray.getDimension(index, 0));
				break;

			case PADDING:
				fitAttrs.setPadding(typedArray.getDimension(index, 0));
				break;

			case PADDING_TOP:
				fitAttrs.setPaddingTop(typedArray.getDimension(index, 0));
				break;

			case PADDING_RIGHT:
				fitAttrs.setPaddingRight(typedArray.getDimension(index, 0));
				break;

			case PADDING_LEFT:
				fitAttrs.setPaddingLeft(typedArray.getDimension(index, 0));
				break;

			case PADDING_BOTTOM:
				fitAttrs.setPaddingBottom(typedArray.getDimension(index, 0));
				break;

			case WIDTH:
				fitAttrs.setWidth(typedArray.getDimension(index, 0));
				break;

			case HEIGHT:
				fitAttrs.setHeight(typedArray.getDimension(index, 0));
				break;

			case MARGIN:
				fitAttrs.setMargin(typedArray.getDimension(index, 0));
				break;

			case MARGIN_TOP:
				fitAttrs.setMarginTop(typedArray.getDimension(index, 0));
				break;

			case MARGIN_RIGHT:
				fitAttrs.setMarginRight(typedArray.getDimension(index, 0));
				break;

			case MARGIN_LEFT:
				fitAttrs.setMarginLeft(typedArray.getDimension(index, 0));
				break;

			case MARGIN_BOTTOM:
				fitAttrs.setMarginBottom(typedArray.getDimension(index, 0));
				break;
			}
		}
		 
		 fitAttrsList.add(fitAttrs);
		 
		 typedArray.recycle();
		 
	}
	
	/**
	 * 设置view参数
	 * @param fitAttrs
	 */
	private void setAttrs(final View view,final FitAttributeSet fitAttrs){
		
		view.post(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				setTextSize(view,fitAttrs);
				setViewParams(view,fitAttrs);
				setViewPadding(view,fitAttrs);
			}
		});
		
		
	}
	
	/**
	 * 设置view的大小、margin值
	 * @param view
	 * @param fitAttrs
	 */
	private void setViewParams(View view,FitAttributeSet fitAttrs){
		//是否设置view的params值
		boolean isParams=false;
		/**
		 * 设置宽度和高度
		 */
		LayoutParams params=view.getLayoutParams();
		
		if(fitAttrs.getWidth() != 0){
			isParams=true;
			params.width=(int) getWidthSize(fitAttrs.getWidth());
		}
		
		if(fitAttrs.getHeight() != 0){
			isParams=true;
			params.height=(int) getHeightSize(fitAttrs.getHeight());
		}
		
		/**
		 * 设置margin值
		 */
		 if (params instanceof MarginLayoutParams)
         {
			 MarginLayoutParams marginParams=(MarginLayoutParams) params;
//			 marginParams.setMargins((int)getWidthSize(fitAttrs.getMargin()), (int)getHeightSize(fitAttrs.getMargin()), (int)getWidthSize(fitAttrs.getMargin()), (int)getHeightSize(fitAttrs.getMargin()));
             
			 if(fitAttrs.getMargin() != 0){
				 isParams=true;
				 marginParams.leftMargin=marginParams.rightMargin=(int)getWidthSize(fitAttrs.getMargin());
				 marginParams.topMargin=marginParams.bottomMargin=(int)getHeightSize(fitAttrs.getMargin());
			 }
         
			 if(fitAttrs.getMarginLeft() != 0){
				 isParams=true;
				 marginParams.leftMargin=(int) getWidthSize(fitAttrs.getMarginLeft());
			    
			 }
			 
			 if(fitAttrs.getMarginTop() != 0){
				 isParams=true;
				 marginParams.topMargin=(int) getHeightSize(fitAttrs.getMarginTop());
			 }
			 
			 if(fitAttrs.getMarginRight() != 0){
				 isParams=true;
				 marginParams.rightMargin=(int) getWidthSize(fitAttrs.getMarginRight());
			 }
			 
			 if(fitAttrs.getMarginBottom() != 0){
				 isParams=true;
				 marginParams.bottomMargin=(int) getHeightSize(fitAttrs.getMarginBottom());
			 }
         }
		 
		 if(isParams){
				view.setLayoutParams(params);
			}
	}
	
	/**
	 * 设置字体的大小
	 */
	private void setTextSize(View view,FitAttributeSet fitAttrs){
		if(view instanceof TextView && fitAttrs != null){
			float size=getWidthSize(fitAttrs.getTextSize());
			if(size != 0){
				((TextView) view).setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
			}
		}
	}
	
	/**
	 * 设置padding值
	 */
	private void setViewPadding(View view,FitAttributeSet fitAttrs){
		
		int left = view.getPaddingLeft();
		int right = view.getPaddingRight(); 
		int top = view.getPaddingTop();
		int bottom = view.getPaddingBottom();
		
		//标志是否设置padding值
		boolean isPadding=false;
		
		if(fitAttrs.getPadding() != 0){
			isPadding=true;
			left=right=(int) getWidthSize(fitAttrs.getPadding());
			top=bottom= (int) getHeightSize(fitAttrs.getPadding());
		}
		
		if(fitAttrs.getPaddingLeft() != 0){
			isPadding=true;
			left=(int) getWidthSize(fitAttrs.getPaddingLeft());
		}
		
		if(fitAttrs.getPaddingTop() != 0){
			isPadding=true;
			top=(int) getWidthSize(fitAttrs.getPaddingTop());
		}
		
		if(fitAttrs.getPaddingRight() != 0){
			isPadding=true;
			right=(int) getWidthSize(fitAttrs.getPaddingRight());
		}
		
		if(fitAttrs.getPaddingBottom() != 0){
			isPadding=true;
			bottom=(int) getWidthSize(fitAttrs.getPaddingBottom());
		}
		
		if(isPadding){
			view.setPadding(left, top, right, bottom);
		}
	}
	
	//获取屏幕的方向
	public boolean isScreenChange() {

		Configuration mConfiguration = context.getResources().getConfiguration(); 
		int ori = mConfiguration.orientation;
		//竖屏
		if (ori == mConfiguration.ORIENTATION_PORTRAIT) {
			return true;
		//横屏
		} else if (ori == mConfiguration.ORIENTATION_LANDSCAPE) {
			return false;
		}
		return false;
	}
	
	/**
	 * 获取一个值的大小
	 * @param size
	 * @return
	 */
	public float getWidthSize(float size){
		
		if (isScreenChange()) {
			return size/designWidth*width;
		}else{
			return size/designHeight*width;
		}
	}
	
	/**
	 * 获取一个值的大小
	 * @param size
	 * @return
	 */
	public float getHeightSize(float size){
		
		if (isScreenChange()) {
			return size/designHeight*height;
		}else{
			return size/designWidth*height;
		}
	}
	
	 private  int getComplexUnit(int data)
	    {
	        return TypedValue.COMPLEX_UNIT_MASK & (data >> TypedValue.COMPLEX_UNIT_SHIFT);
	    }

	    public  boolean isPxVal(TypedValue val)
	    {
	        if (val != null && val.type == TypedValue.TYPE_DIMENSION &&
	                getComplexUnit(val.data) == TypedValue.COMPLEX_UNIT_PX)
	        {
	            return true;
	        }
	        return false;
	    }
	
	/**
	 * builder用于动态设置view的参数
	 * @author Flyjun
	 *
	 */
	public static class Builder{
		private FitAttributeSet fitAttrs;
		
		public Builder() {
			// TODO Auto-generated constructor stub
			this.fitAttrs =new FitAttributeSet();
		}
		public Builder setWidth(float width) {
			this.fitAttrs.setWidth(width);
			return this;
		}
		public Builder setHeight(float height) {
			this.fitAttrs.setHeight(height);
			return this;
		}
		public Builder setTextSize(float textSize) {
			this.fitAttrs.setTextSize(textSize);
			return this;
		}
		public Builder setMargin(float margin) {
			this.fitAttrs.setMargin(margin);
			return this;
		}
		public Builder setMarginLeft(float marginLeft) {
			this.fitAttrs.setMarginLeft(marginLeft);
			return this;
		}
		public Builder setMarginRight(float marginRight) {
			this.fitAttrs.setMarginRight(marginRight);
			return this;
		}
		public Builder setMarginTop(float marginTop) {
			this.fitAttrs.setMarginTop(marginTop);
			return this;
		}
		public Builder setMarginBottom(float marginBottom) {
			this.fitAttrs.setMarginBottom(marginBottom);
			return this;
		}
		public Builder setPadding(float padding) {
			this.fitAttrs.setPadding(padding);
			return this;
		}
		public Builder setPaddingLeft(float paddingLeft) {
			this.fitAttrs.setPaddingLeft(paddingLeft);
			return this;
		}
		public Builder setPaddingRight(float paddingRight) {
			this.fitAttrs.setPaddingRight(paddingRight);
			return this;
		}
		public Builder setPaddingTop(float paddingTop) {
			this.fitAttrs.setPaddingTop(paddingTop);
			return this;
		}
		public Builder setPaddingBottom(float paddingBottom) {
			this.fitAttrs.setPaddingBottom(paddingBottom);
			return this;
		}
		
		public void builder(){
			if(null != dynamicView){
				getInstance().setViews(dynamicView, fitAttrs);
			}
		}
	}
}
