package com.flyjun.fitview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class FixLinearLayout extends LinearLayout{
	
	private FixHelper fixHelper;

	public FixLinearLayout(Context context) {
		super(context);
		fixHelper= FixHelper.newInstance(context);
	}

	public FixLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		fixHelper= FixHelper.newInstance(context);
	}

	public FixLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		fixHelper= FixHelper.newInstance(context);
	}


	@Override
	public LayoutParams generateLayoutParams(AttributeSet attrs) {
		// TODO Auto-generated method stub
		
		/**
		 * 获取子控件的AttributeSet
		 */
		fixHelper.setViewAttr(fixHelper,attrs);
		
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
	            fixHelper.setViews(view, fixHelper.fixAttrsList.get(i));
	        }

	}
	
	
}
