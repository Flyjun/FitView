package com.flyjun.fitview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class FitLinearLayout extends LinearLayout{
	
	private FitHelper fitHelper;

	public FitLinearLayout(Context context) {
		super(context);
		fitHelper = FitHelper.newInstance(context);
	}

	public FitLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		fitHelper = FitHelper.newInstance(context);
	}

	public FitLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		fitHelper = FitHelper.newInstance(context);
	}


	@Override
	public LayoutParams generateLayoutParams(AttributeSet attrs) {
		// TODO Auto-generated method stub
		
		/**
		 * 获取子控件的AttributeSet
		 */
		fitHelper.setViewAttr(fitHelper,attrs);
		
		return super.generateLayoutParams(attrs);
	}
	
	/**
	 * 当View中所有的子控件均被映射成xml后触发
	 */
	@Override
	protected void onFinishInflate() {
		// TODO Auto-generated method stub
		super.onFinishInflate();
		
		int count=getChildCount();
		 for (int i = 0;i<count; i++)
	        {
	            View view = getChildAt(i);
	            fitHelper.setViews(view, fitHelper.fitAttrsList.get(i));
	        }

	}
	
	
}
