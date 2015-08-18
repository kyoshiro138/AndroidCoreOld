package com.jp.androidcore.core.navigator;

/**
 * NavigationActivity is implemented in Activity or FragmentActivity for navigation
 * @param <TNavigator>
 *     Navigable interface
 */
public interface NavigationActivity<TNavigator extends Navigable> {
    TNavigator getNavigator();
}
