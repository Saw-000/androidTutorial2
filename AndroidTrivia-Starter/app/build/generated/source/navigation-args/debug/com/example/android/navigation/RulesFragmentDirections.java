package com.example.android.navigation;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class RulesFragmentDirections {
  private RulesFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionRulesFragmentToGameFragment() {
    return new ActionOnlyNavDirections(R.id.action_rulesFragment_to_gameFragment);
  }
}
