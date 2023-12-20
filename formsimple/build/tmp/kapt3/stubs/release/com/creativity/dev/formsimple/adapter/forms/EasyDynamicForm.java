package com.creativity.dev.formsimple.adapter.forms;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B;\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f\u00a2\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J \u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\nj\b\u0012\u0004\u0012\u00020\u0014`\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J>\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0016J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0014H\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016\u00a8\u0006!"}, d2 = {"Lcom/creativity/dev/formsimple/adapter/forms/EasyDynamicForm;", "Lcom/creativity/dev/formsimple/adapter/forms/DynamicListAdapter;", "model", "", "Lcom/creativity/dev/formsimple/model/ListDynamic;", "mContext", "Landroid/content/Context;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "positionRow", "Ljava/util/ArrayList;", "Lcom/creativity/dev/formsimple/model/CollectionControlsList;", "Lkotlin/collections/ArrayList;", "(Ljava/util/List;Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView;Ljava/util/ArrayList;)V", "eventChecked", "", "isSelected", "", "position", "getResultAll", "Lcom/creativity/dev/formsimple/model/ResponseFormsIGB;", "tag", "", "getResultByTag", "getResults", "init", "", "listMenu", "updateRow", "tagOrTitle", "objRespIGB", "validateAll", "validateByTag", "formsimple_release"})
public final class EasyDynamicForm extends com.creativity.dev.formsimple.adapter.forms.DynamicListAdapter {
    
    public EasyDynamicForm(@org.jetbrains.annotations.NotNull()
    java.util.List<com.creativity.dev.formsimple.model.ListDynamic> model, @org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.creativity.dev.formsimple.model.CollectionControlsList> positionRow) {
        super(null, null, null, null);
    }
    
    @java.lang.Override()
    public void init(@org.jetbrains.annotations.NotNull()
    java.util.List<com.creativity.dev.formsimple.model.ListDynamic> listMenu, @org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.creativity.dev.formsimple.model.CollectionControlsList> positionRow) {
    }
    
    @java.lang.Override()
    public boolean validateAll() {
        return false;
    }
    
    @java.lang.Override()
    public boolean validateByTag(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.creativity.dev.formsimple.model.ResponseFormsIGB getResultByTag(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.ArrayList<com.creativity.dev.formsimple.model.ResponseFormsIGB> getResultAll(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<com.creativity.dev.formsimple.model.ResponseFormsIGB> getResults(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
        return null;
    }
    
    @java.lang.Override()
    public boolean updateRow(@org.jetbrains.annotations.NotNull()
    java.lang.String tagOrTitle, @org.jetbrains.annotations.NotNull()
    com.creativity.dev.formsimple.model.ResponseFormsIGB objRespIGB) {
        return false;
    }
    
    @java.lang.Override()
    public int eventChecked(boolean isSelected, int position) {
        return 0;
    }
}