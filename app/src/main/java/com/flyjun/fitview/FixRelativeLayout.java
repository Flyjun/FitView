package com.flyjun.fitview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class FixRelativeLayout extends RelativeLayout{
	
	private FixHelper fixHelper;
	
	public FixRelativeLayout(Context context, AttributeSet attrs,
							 int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
		fixHelper= FixHelper.newInstance(context);
	}

	public FixRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		fixHelper= FixHelper.newInstance(context);
	}

	public FixRelativeLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
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
	
	@Override
	protected void onFinishInflate() {
		// TODO Auto-generated method stub
		super.onFinishInflate();
		
		/**
		 * 遍历子控件
		 */
		int count=getChildCount();
		 for (int i = 0;i<count; i++)
	        {
	            View view = getChildAt(i);
	            fixHelper.setViews(view, fixHelper.fixAttrsList.get(i));
	           
	        }
	}
		
	
}
