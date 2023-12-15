package com.creativity.dev.formsimple.adapter.forms;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u00032\u00020\u0004:\u00011B;\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\'H\u0016J>\u0010(\u001a\u00020#2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fH&J\u001c\u0010*\u001a\u00020#2\n\u0010+\u001a\u00060\u0002R\u00020\u00002\u0006\u0010,\u001a\u00020\'H\u0016J\u001c\u0010-\u001a\u00060\u0002R\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\'H\u0016R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u00062"}, d2 = {"Lcom/creativity/dev/formsimple/adapter/forms/DynamicListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/creativity/dev/formsimple/adapter/forms/DynamicListAdapter$DynamicListHolder;", "Lcom/creativity/dev/formsimple/interfaces/DelegateDialogAlert;", "Lcom/creativity/dev/formsimple/adapter/forms/Interfaces/DynamicListAdapterI;", "model", "", "Lcom/creativity/dev/formsimple/model/ListDynamic;", "mContext", "Landroid/content/Context;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "positionRow", "Ljava/util/ArrayList;", "Lcom/creativity/dev/formsimple/model/CollectionControlsList;", "Lkotlin/collections/ArrayList;", "(Ljava/util/List;Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView;Ljava/util/ArrayList;)V", "list", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getMContext", "()Landroid/content/Context;", "getPositionRow", "()Ljava/util/ArrayList;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "testOut", "", "getTestOut", "()Z", "setTestOut", "(Z)V", "getDataResponse", "", "str", "", "getItemCount", "", "init", "listMenu", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DynamicListHolder", "formsimple_release"})
public abstract class DynamicListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.creativity.dev.formsimple.adapter.forms.DynamicListAdapter.DynamicListHolder> implements com.creativity.dev.formsimple.interfaces.DelegateDialogAlert, com.creativity.dev.formsimple.adapter.forms.Interfaces.DynamicListAdapterI {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context mContext = null;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.creativity.dev.formsimple.model.ListDynamic> list;
    @org.jetbrains.annotations.NotNull
    private final androidx.recyclerview.widget.RecyclerView recyclerView = null;
    private boolean testOut = false;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<com.creativity.dev.formsimple.model.CollectionControlsList> positionRow = null;
    
    public DynamicListAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.creativity.dev.formsimple.model.ListDynamic> model, @org.jetbrains.annotations.NotNull
    android.content.Context mContext, @org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView recyclerView, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.creativity.dev.formsimple.model.CollectionControlsList> positionRow) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getMContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.creativity.dev.formsimple.model.ListDynamic> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull
    java.util.List<com.creativity.dev.formsimple.model.ListDynamic> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.recyclerview.widget.RecyclerView getRecyclerView() {
        return null;
    }
    
    public final boolean getTestOut() {
        return false;
    }
    
    public final void setTestOut(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.creativity.dev.formsimple.model.CollectionControlsList> getPositionRow() {
        return null;
    }
    
    public abstract void init(@org.jetbrains.annotations.NotNull
    java.util.List<com.creativity.dev.formsimple.model.ListDynamic> listMenu, @org.jetbrains.annotations.NotNull
    android.content.Context mContext, @org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView recyclerView, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.creativity.dev.formsimple.model.CollectionControlsList> positionRow);
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.creativity.dev.formsimple.adapter.forms.DynamicListAdapter.DynamicListHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.creativity.dev.formsimple.adapter.forms.DynamicListAdapter.DynamicListHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public void getDataResponse(@org.jetbrains.annotations.NotNull
    java.lang.String str) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0016J\u0010\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QH\u0016J\u0010\u0010R\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0016J\u0016\u0010S\u001a\u00020K2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020V0UH\u0016J\b\u0010W\u001a\u00020QH\u0016J\u0010\u0010X\u001a\u00020K2\u0006\u0010Y\u001a\u00020\u0006H\u0016J\u0010\u0010Z\u001a\u00020K2\u0006\u0010[\u001a\u00020OH\u0002R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%R\u001a\u0010/\u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R\u001a\u00102\u001a\u000203X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u000203X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u00105\"\u0004\b:\u00107R\u001a\u0010;\u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010#\"\u0004\b=\u0010%R\u001a\u0010>\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u000b\"\u0004\b@\u0010\rR\u001a\u0010A\u001a\u00020BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010#\"\u0004\bI\u0010%\u00a8\u0006\\"}, d2 = {"Lcom/creativity/dev/formsimple/adapter/forms/DynamicListAdapter$DynamicListHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Lcom/creativity/dev/formsimple/interfaces/EventListDynamic;", "Lcom/creativity/dev/formsimple/interfaces/EventList;", "view", "Landroid/view/View;", "(Lcom/creativity/dev/formsimple/adapter/forms/DynamicListAdapter;Landroid/view/View;)V", "UnvContent", "Landroid/widget/LinearLayout;", "getUnvContent", "()Landroid/widget/LinearLayout;", "setUnvContent", "(Landroid/widget/LinearLayout;)V", "check", "Landroid/widget/CheckBox;", "getCheck", "()Landroid/widget/CheckBox;", "setCheck", "(Landroid/widget/CheckBox;)V", "content", "getContent", "setContent", "contentImg", "getContentImg", "setContentImg", "contentLetter", "Landroid/widget/RelativeLayout;", "getContentLetter", "()Landroid/widget/RelativeLayout;", "setContentLetter", "(Landroid/widget/RelativeLayout;)V", "description", "Landroid/widget/TextView;", "getDescription", "()Landroid/widget/TextView;", "setDescription", "(Landroid/widget/TextView;)V", "editText", "Landroid/widget/EditText;", "getEditText", "()Landroid/widget/EditText;", "setEditText", "(Landroid/widget/EditText;)V", "errorMessage", "getErrorMessage", "setErrorMessage", "icon", "getIcon", "setIcon", "img", "Landroid/widget/ImageView;", "getImg", "()Landroid/widget/ImageView;", "setImg", "(Landroid/widget/ImageView;)V", "img2", "getImg2", "setImg2", "letter", "getLetter", "setLetter", "seperatorContent", "getSeperatorContent", "setSeperatorContent", "styleEditText", "Lcom/google/android/material/textfield/TextInputLayout;", "getStyleEditText", "()Lcom/google/android/material/textfield/TextInputLayout;", "setStyleEditText", "(Lcom/google/android/material/textfield/TextInputLayout;)V", "title", "getTitle", "setTitle", "evenSetSimpleString", "", "str", "", "eventChecked", "", "isSelected", "", "eventEdtiText", "eventSetList", "inputList", "", "", "getSelected", "onClick", "v", "response", "pos", "formsimple_release"})
    public final class DynamicListHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements android.view.View.OnClickListener, com.creativity.dev.formsimple.interfaces.EventListDynamic, com.creativity.dev.formsimple.interfaces.EventList {
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView title;
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView letter;
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView errorMessage;
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView icon;
        @org.jetbrains.annotations.NotNull
        private android.widget.EditText editText;
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView description;
        @org.jetbrains.annotations.NotNull
        private android.widget.CheckBox check;
        @org.jetbrains.annotations.NotNull
        private android.widget.RelativeLayout contentLetter;
        @org.jetbrains.annotations.NotNull
        private android.widget.LinearLayout content;
        @org.jetbrains.annotations.NotNull
        private android.widget.LinearLayout UnvContent;
        @org.jetbrains.annotations.NotNull
        private android.widget.LinearLayout contentImg;
        @org.jetbrains.annotations.NotNull
        private android.widget.LinearLayout seperatorContent;
        @org.jetbrains.annotations.NotNull
        private com.google.android.material.textfield.TextInputLayout styleEditText;
        @org.jetbrains.annotations.NotNull
        private android.widget.ImageView img;
        @org.jetbrains.annotations.NotNull
        private android.widget.ImageView img2;
        
        public DynamicListHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTitle() {
            return null;
        }
        
        public final void setTitle(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getLetter() {
            return null;
        }
        
        public final void setLetter(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getErrorMessage() {
            return null;
        }
        
        public final void setErrorMessage(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getIcon() {
            return null;
        }
        
        public final void setIcon(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.EditText getEditText() {
            return null;
        }
        
        public final void setEditText(@org.jetbrains.annotations.NotNull
        android.widget.EditText p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getDescription() {
            return null;
        }
        
        public final void setDescription(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.CheckBox getCheck() {
            return null;
        }
        
        public final void setCheck(@org.jetbrains.annotations.NotNull
        android.widget.CheckBox p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.RelativeLayout getContentLetter() {
            return null;
        }
        
        public final void setContentLetter(@org.jetbrains.annotations.NotNull
        android.widget.RelativeLayout p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.LinearLayout getContent() {
            return null;
        }
        
        public final void setContent(@org.jetbrains.annotations.NotNull
        android.widget.LinearLayout p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.LinearLayout getUnvContent() {
            return null;
        }
        
        public final void setUnvContent(@org.jetbrains.annotations.NotNull
        android.widget.LinearLayout p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.LinearLayout getContentImg() {
            return null;
        }
        
        public final void setContentImg(@org.jetbrains.annotations.NotNull
        android.widget.LinearLayout p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.LinearLayout getSeperatorContent() {
            return null;
        }
        
        public final void setSeperatorContent(@org.jetbrains.annotations.NotNull
        android.widget.LinearLayout p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.android.material.textfield.TextInputLayout getStyleEditText() {
            return null;
        }
        
        public final void setStyleEditText(@org.jetbrains.annotations.NotNull
        com.google.android.material.textfield.TextInputLayout p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getImg() {
            return null;
        }
        
        public final void setImg(@org.jetbrains.annotations.NotNull
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getImg2() {
            return null;
        }
        
        public final void setImg2(@org.jetbrains.annotations.NotNull
        android.widget.ImageView p0) {
        }
        
        @java.lang.Override
        public void onClick(@org.jetbrains.annotations.NotNull
        android.view.View v) {
        }
        
        @java.lang.Override
        public void eventEdtiText(@org.jetbrains.annotations.NotNull
        java.lang.String str) {
        }
        
        @java.lang.Override
        public int eventChecked(boolean isSelected) {
            return 0;
        }
        
        @java.lang.Override
        public boolean getSelected() {
            return false;
        }
        
        @java.lang.Override
        public void evenSetSimpleString(@org.jetbrains.annotations.NotNull
        java.lang.String str) {
        }
        
        @java.lang.Override
        public void eventSetList(@org.jetbrains.annotations.NotNull
        java.util.List<? extends java.lang.Object> inputList) {
        }
        
        private final void response(int pos) {
        }
    }
}