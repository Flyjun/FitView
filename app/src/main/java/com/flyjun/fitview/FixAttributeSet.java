package com.flyjun.fitview;

/**
 * 适配支持的属性值
 * @author Flyjun
 *
 */
public class FixAttributeSet {
	
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
	public FixAttributeSet setWidth(float width) {
		this.width = width;
		return this;
	}
	public float getHeight() {
		return height;
	}
	public FixAttributeSet setHeight(float height) {
		this.height = height;
		return this;
	}
	public float getTextSize() {
		return textSize;
	}
	public FixAttributeSet setTextSize(float textSize) {
		this.textSize = textSize;
		return this;
	}
	public float getMargin() {
		return margin;
	}
	public FixAttributeSet setMargin(float margin) {
		this.margin = margin;
		return this;
	}
	public float getMarginLeft() {
		return marginLeft;
	}
	public FixAttributeSet setMarginLeft(float marginLeft) {
		this.marginLeft = marginLeft;
		return this;
	}
	public float getMarginRight() {
		return marginRight;
	}
	public FixAttributeSet setMarginRight(float marginRight) {
		this.marginRight = marginRight;
		return this;
	}
	public float getMarginTop() {
		return marginTop;
	}
	public FixAttributeSet setMarginTop(float marginTop) {
		this.marginTop = marginTop;
		return this;
	}
	public float getMarginBottom() {
		return marginBottom;
	}
	public FixAttributeSet setMarginBottom(float marginBottom) {
		this.marginBottom = marginBottom;
		return this;
	}
	public float getPadding() {
		return padding;
	}
	public FixAttributeSet setPadding(float padding) {
		this.padding = padding;
		return this;
	}
	public float getPaddingLeft() {
		return paddingLeft;
	}
	public FixAttributeSet setPaddingLeft(float paddingLeft) {
		this.paddingLeft = paddingLeft;
		return this;
	}
	public float getPaddingRight() {
		return paddingRight;
	}
	public FixAttributeSet setPaddingRight(float paddingRight) {
		this.paddingRight = paddingRight;
		return this;
	}
	public float getPaddingTop() {
		return paddingTop;
	}
	public FixAttributeSet setPaddingTop(float paddingTop) {
		this.paddingTop = paddingTop;
		return this;
	}
	public float getPaddingBottom() {
		return paddingBottom;
	}
	public FixAttributeSet setPaddingBottom(float paddingBottom) {
		this.paddingBottom = paddingBottom;
		return this;
	}
	@Override
	public String toString() {
		return "FixAttributeSet [width=" + width + ", height=" + height
				+ ", textSize=" + textSize + ", margin=" + margin
				+ ", marginLeft=" + marginLeft + ", marginRight=" + marginRight
				+ ", marginTop=" + marginTop + ", marginBottom=" + marginBottom
				+ ", padding=" + padding + ", paddingLeft=" + paddingLeft
				+ ", paddingRight=" + paddingRight + ", paddingTop="
				+ paddingTop + ", paddingBottom=" + paddingBottom + "]";
	}
	
}
