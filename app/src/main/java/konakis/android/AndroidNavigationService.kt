package konakis.android

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import konakis.navigation.NavigationService
import konakis.viewmodel.KonakisViewModelFactory
import sample.R

class AndroidNavigationService(
    private val supportFragmentManager: FragmentManager,
    private val viewRouter: ViewRouter
) : NavigationService {

    override fun showViewModel(factory: KonakisViewModelFactory) {
        val fragment = viewRouter.routeToView(factory)
        showFragment(fragment)
    }

    private fun showFragment(fragment: Fragment) {
        val tag = fragment.javaClass.simpleName

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment, tag)
            .commit()
    }
}