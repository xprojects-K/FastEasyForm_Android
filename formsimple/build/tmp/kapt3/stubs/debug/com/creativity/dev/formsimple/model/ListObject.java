package com.creativity.dev.formsimple.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\t\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b\'\u0010\u0014R\u001a\u0010(\u001a\u00020)X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0012\"\u0004\b0\u0010\u0014\u00a8\u00062"}, d2 = {"Lcom/creativity/dev/formsimple/model/ListObject;", "Ljava/io/Serializable;", "()V", "backgroundContent", "", "getBackgroundContent", "()I", "setBackgroundContent", "(I)V", "colorTitleToolbar", "getColorTitleToolbar", "setColorTitleToolbar", "colorToolbar", "getColorToolbar", "setColorToolbar", "emptyMessage", "", "getEmptyMessage", "()Ljava/lang/String;", "setEmptyMessage", "(Ljava/lang/String;)V", "imageEmpty", "getImageEmpty", "setImageEmpty", "isSingle", "", "()Z", "setSingle", "(Z)V", "list", "Ljava/util/ArrayList;", "Lcom/creativity/dev/formsimple/model/Select;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "title", "getTitle", "setTitle", "titleSize", "", "getTitleSize", "()F", "setTitleSize", "(F)V", "titleToolbar", "getTitleToolbar", "setTitleToolbar", "Companion", "formsimple_debug"})
public final class ListObject implements java.io.Serializable {
    @org.jetbrains.annotations.NotNull
    private java.lang.String title = "";
    @org.jetbrains.annotations.NotNull
    private java.lang.String titleToolbar = "";
    @org.jetbrains.annotations.NotNull
    private java.lang.String emptyMessage = "";
    private boolean isSingle = false;
    private float titleSize = 20.0F;
    private int colorToolbar = 0;
    private int colorTitleToolbar = 0;
    private int backgroundContent = 0;
    private int imageEmpty = 0;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.creativity.dev.formsimple.model.Select> list;
    @org.jetbrains.annotations.NotNull
    public static final com.creativity.dev.formsimple.model.ListObject.Companion Companion = null;
    public static com.creativity.dev.formsimple.interfaces.EventList eventList;
    
    public ListObject() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTitleToolbar() {
        return null;
    }
    
    public final void setTitleToolbar(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEmptyMessage() {
        return null;
    }
    
    public final void setEmptyMessage(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final boolean isSingle() {
        return false;
    }
    
    public final void setSingle(boolean p0) {
    }
    
    public final float getTitleSize() {
        return 0.0F;
    }
    
    public final void setTitleSize(float p0) {
    }
    
    public final int getColorToolbar() {
        return 0;
    }
    
    public final void setColorToolbar(int p0) {
    }
    
    public final int getColorTitleToolbar() {
        return 0;
    }
    
    public final void setColorTitleToolbar(int p0) {
    }
    
    public final int getBackgroundContent() {
        return 0;
    }
    
    public final void setBackgroundContent(int p0) {
    }
    
    public final int getImageEmpty() {
        return 0;
    }
    
    public final void setImageEmpty(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.creativity.dev.formsimple.model.Select> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.creativity.dev.formsimple.model.Select> p0) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/creativity/dev/formsimple/model/ListObject$Companion;", "", "()V", "eventList", "Lcom/creativity/dev/formsimple/interfaces/EventList;", "getEventList", "()Lcom/creativity/dev/formsimple/interfaces/EventList;", "setEventList", "(Lcom/creativity/dev/formsimple/interfaces/EventList;)V", "formsimple_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.creativity.dev.formsimple.interfaces.EventList getEventList() {
            return null;
        }
        
        public final void setEventList(@org.jetbrains.annotations.NotNull
        com.creativity.dev.formsimple.interfaces.EventList p0) {
        }
    }
}