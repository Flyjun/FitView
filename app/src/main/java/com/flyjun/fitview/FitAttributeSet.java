package com.flyjun.fitview;

/**
 * 适配支持的属性值
 * @author Flyjun
 *
 */
public class FitAttributeSet {
	
	public float width;
    public float height;
	
	public float textSize;

	public float margin;
	public float marginLeft;
	public float marginRight;
	public float marginTop;
	public float marginBottom;

	public float padding;
	public float paddingLeft;
	public float paddingRight;
	public float paddingTop;
	public float paddingBottom;
	
	public float getWidth() {
		return width;
	}
	public FitAttributeSet setWidth(float width) {
		this.width = width;
		return this;
	}
	public float getHeight() {
		return height;
	}
	public FitAttributeSet setHeight(float height) {
		this.height = height;
		return this;
	}
	public float getTextSize() {
		return textSize;
	}
	public FitAttributeSet setTextSize(float textSize) {
		this.textSize = textSize;
		return this;
	}
	public float getMargin() {
		return margin;
	}
	public FitAttributeSet setMargin(float margin) {
		this.margin = margin;
		return this;
	}
	public float getMarginLeft() {
		return marginLeft;
	}
	public FitAttributeSet setMarginLeft(float marginLeft) {
		this.marginLeft = marginLeft;
		return this;
	}
	public float getMarginRight() {
		return marginRight;
	}
	public FitAttributeSet setMarginRight(float marginRight) {
		this.marginRight = marginRight;
		return this;
	}
	public float getMarginTop() {
		return marginTop;
	}
	public FitAttributeSet setMarginTop(float marginTop) {
		this.marginTop = marginTop;
		return this;
	}
	public float getMarginBottom() {
		return marginBottom;
	}
	public FitAttributeSet setMarginBottom(float marginBottom) {
		this.marginBottom = marginBottom;
		return this;
	}
	public float getPadding() {
		return padding;
	}
	public FitAttributeSet setPadding(float padding) {
		this.padding = padding;
		return this;
	}
	public float getPaddingLeft() {
		return paddingLeft;
	}
	public FitAttributeSet setPaddingLeft(float paddingLeft) {
		this.paddingLeft = paddingLeft;
		return this;
	}
	public float getPaddingRight() {
		return paddingRight;
	}
	public FitAttributeSet setPaddingRight(float paddingRight) {
		this.paddingRight = paddingRight;
		return this;
	}
	public float getPaddingTop() {
		return paddingTop;
	}
	public FitAttributeSet setPaddingTop(float paddingTop) {
		this.paddingTop = paddingTop;
		return this;
	}
	public float getPaddingBottom() {
		return paddingBottom;
	}
	public FitAttributeSet setPaddingBottom(float paddingBottom) {
		this.paddingBottom = paddingBottom;
		return this;
	}
	@Override
	public String toString() {
		return "FitAttributeSet [width=" + width + ", height=" + height
				+ ", textSize=" + textSize + ", margin=" + margin
				+ ", marginLeft=" + marginLeft + ", marginRight=" + marginRight
				+ ", marginTop=" + marginTop + ", marginBottom=" + marginBottom
				+ ", padding=" + padding + ", paddingLeft=" + paddingLeft
				+ ", paddingRight=" + paddingRight + ", paddingTop="
				+ paddingTop + ", paddingBottom=" + paddingBottom + "]";
	}
	
}
