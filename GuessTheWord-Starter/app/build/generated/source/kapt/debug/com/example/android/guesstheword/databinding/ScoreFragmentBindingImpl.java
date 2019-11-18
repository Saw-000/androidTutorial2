package com.example.android.guesstheword.databinding;
import com.example.android.guesstheword.R;
import com.example.android.guesstheword.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ScoreFragmentBindingImpl extends ScoreFragmentBinding implements com.example.android.guesstheword.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.you_scored_text, 2);
        sViewsWithIds.put(R.id.score_text, 3);
    }
    // views
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ScoreFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ScoreFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[2]
            );
        this.playAgainButton.setTag(null);
        this.scoreLayout.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.example.android.guesstheword.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.scoreViewModel == variableId) {
            setScoreViewModel((com.example.android.guesstheword.screens.score.ScoreViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setScoreViewModel(@Nullable com.example.android.guesstheword.screens.score.ScoreViewModel ScoreViewModel) {
        this.mScoreViewModel = ScoreViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.scoreViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.example.android.guesstheword.screens.score.ScoreViewModel scoreViewModel = mScoreViewModel;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.playAgainButton.setOnClickListener(mCallback1);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // scoreViewModel != null
        boolean scoreViewModelJavaLangObjectNull = false;
        // scoreViewModel
        com.example.android.guesstheword.screens.score.ScoreViewModel scoreViewModel = mScoreViewModel;



        scoreViewModelJavaLangObjectNull = (scoreViewModel) != (null);
        if (scoreViewModelJavaLangObjectNull) {


            scoreViewModel.onPlayAgain();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): scoreViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}