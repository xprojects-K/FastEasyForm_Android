package com.creativity.dev.formsimple.adapter.options;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001)B-\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fB\u0005\u00a2\u0006\u0002\u0010\rJ\b\u0010\u001f\u001a\u00020\u0013H\u0016J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u001c\u0010!\u001a\u00020\"2\n\u0010#\u001a\u00060\u0002R\u00020\u00002\u0006\u0010$\u001a\u00020\u0013H\u0016J\u001c\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\u0013H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006*"}, d2 = {"Lcom/creativity/dev/formsimple/adapter/options/SelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/creativity/dev/formsimple/adapter/options/SelectAdapter$MyViewHolder;", "listMenu", "", "Lcom/creativity/dev/formsimple/model/Select;", "asset", "Landroid/content/res/AssetManager;", "mContext", "Landroid/content/Context;", "isSingleSelection", "", "(Ljava/util/List;Landroid/content/res/AssetManager;Landroid/content/Context;Z)V", "()V", "getAsset", "()Landroid/content/res/AssetManager;", "setAsset", "(Landroid/content/res/AssetManager;)V", "imageCheck", "", "imageNegative", "imagePositive", "list", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "getItemCount", "getListReady", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MyViewHolder", "formsimple_release"})
public final class SelectAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.creativity.dev.formsimple.adapter.options.SelectAdapter.MyViewHolder> {
    public java.util.List<com.creativity.dev.formsimple.model.Select> list;
    public android.content.res.AssetManager asset;
    public android.content.Context mContext;
    private int imagePositive;
    private int imageNegative;
    private int imageCheck;
    private boolean isSingleSelection = false;
    
    public SelectAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.creativity.dev.formsimple.model.Select> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull
    java.util.List<com.creativity.dev.formsimple.model.Select> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.res.AssetManager getAsset() {
        return null;
    }
    
    public final void setAsset(@org.jetbrains.annotations.NotNull
    android.content.res.AssetManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull
    android.content.Context p0) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public SelectAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.creativity.dev.formsimple.model.Select> listMenu, @org.jetbrains.annotations.NotNull
    android.content.res.AssetManager asset, @org.jetbrains.annotations.NotNull
    android.content.Context mContext, boolean isSingleSelection) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.creativity.dev.formsimple.model.Select> getListReady() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.creativity.dev.formsimple.adapter.options.SelectAdapter.MyViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.creativity.dev.formsimple.adapter.options.SelectAdapter.MyViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001fH\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u0005H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\'"}, d2 = {"Lcom/creativity/dev/formsimple/adapter/options/SelectAdapter$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Lcom/creativity/dev/formsimple/interfaces/EventListDynamic;", "view", "Landroid/view/View;", "(Lcom/creativity/dev/formsimple/adapter/options/SelectAdapter;Landroid/view/View;)V", "UnvContent", "Landroid/widget/LinearLayout;", "getUnvContent", "()Landroid/widget/LinearLayout;", "setUnvContent", "(Landroid/widget/LinearLayout;)V", "contentImg", "Landroid/widget/ImageView;", "getContentImg", "()Landroid/widget/ImageView;", "setContentImg", "(Landroid/widget/ImageView;)V", "icon", "getIcon", "setIcon", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "eventChecked", "", "isSelected", "", "eventEdtiText", "", "str", "", "getSelected", "onClick", "v", "formsimple_release"})
    public final class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements android.view.View.OnClickListener, com.creativity.dev.formsimple.interfaces.EventListDynamic {
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView title;
        @org.jetbrains.annotations.NotNull
        private android.widget.LinearLayout UnvContent;
        @org.jetbrains.annotations.NotNull
        private android.widget.ImageView contentImg;
        @org.jetbrains.annotations.NotNull
        private android.widget.ImageView icon;
        
        public MyViewHolder(@org.jetbrains.annotations.NotNull
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
        public final android.widget.LinearLayout getUnvContent() {
            return null;
        }
        
        public final void setUnvContent(@org.jetbrains.annotations.NotNull
        android.widget.LinearLayout p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getContentImg() {
            return null;
        }
        
        public final void setContentImg(@org.jetbrains.annotations.NotNull
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getIcon() {
            return null;
        }
        
        public final void setIcon(@org.jetbrains.annotations.NotNull
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
    }
}