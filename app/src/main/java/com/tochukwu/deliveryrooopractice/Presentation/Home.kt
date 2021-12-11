package com.tochukwu.deliveryrooopractice.Presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.tochukwu.deliveryrooopractice.Core.Adapter
import com.tochukwu.deliveryrooopractice.R
import com.tochukwu.deliveryrooopractice.databinding.ActivityHomeBinding
import kotlinx.coroutines.flow.collectLatest

class Home : Fragment(R.layout.activity_home){

    private val viewModel: NewsViewModel by viewModels()

    private var currentBinding: ActivityHomeBinding? = null
    private val binding get() = currentBinding




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentBinding = ActivityHomeBinding.bind(view)
        val homeAdapter = Adapter()

        binding?.apply {
            rvAllNews?.apply {
                adapter = homeAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
                itemAnimator?.changeDuration = 0
            }


            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                viewModel.state.collectLatest{ result->
                    when(result){
                        is NewsViewModel.NewsEvent.Success ->{
                            homeAdapter.submitList(result.art)
                        }
                    }


                }
            }
        }

    }
}


/**
 *
 * viewLifecycleOwner.lifecycleScope.launchWhenStarted {
viewModel.searchResults.collectLatest { data ->
newsArticleAdapter.submitData(data)


newsArticleAdapter.stateRestorationPolicy =
RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY

binding.apply {
setHasFixedSize(true)
itemAnimator?.changeDuration = 0
}

viewLifecycleOwner.lifecycleScope.launchWhenStarted {
viewModel.breakingNews.collect {
val result = it ?: return@collect

swipeRefreshLayout.isRefreshing = result is Resource.Loading<*>
recyclerView.isVisible = !result.data.isNullOrEmpty()
textViewError.isVisible = result.error != null && result.data.isNullOrEmpty()
buttonRetry.isVisible = result.error != null && result.data.isNullOrEmpty()
textViewError.text = getString(
R.string.could_not_refresh,
result.error?.localizedMessage
?: getString(R.string.unknown_error_occurred)
)

newsArticleAdapter.submitList(result.data) {
if (viewModel.pendingScrollToTopAfterRefresh) {
recyclerView.scrollToPosition(0)
viewModel.pendingScrollToTopAfterRefresh = false
}
}
}
}

swipeRefreshLayout.setOnRefreshListener {
viewModel.onManualRefresh()
}

buttonRetry.setOnClickListener {
viewModel.onManualRefresh()
}

viewLifecycleOwner.lifecycleScope.launchWhenStarted {
viewModel.events.collect { event ->
when (event) {
is BreakingNewsViewModel.Event.ShowErrorMessage ->
showSnackbar(
getString(
R.string.could_not_refresh,
event.error.localizedMessage
?: getString(R.string.unknown_error_occurred)
)
)
}.exhaustive
}
}
}

setHasOptionsMenu(true)
}

override fun onStart() {
super.onStart()
viewModel.onStart()
}

override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
inflater.inflate(R.menu.menu_breaking_news, menu)
}

override fun onOptionsItemSelected(item: MenuItem) =
when (item.itemId) {
R.id.action_refresh -> {
viewModel.onManualRefresh()
true
}
else -> super.onOptionsItemSelected(item)
}

override fun onBottomNavigationFragmentReselected() {
binding.recyclerView.scrollToPosition(0)
}

override fun onDestroyView() {
super.onDestroyView()
currentBinding = null
}





 */

/**

class BreakingNewsFragment : Fragment(R.layout.fragment_breaking_news) {

lateinit var viewModel : NewsViewModel
lateinit var newsAdapter: NewsAdapter

val TAG = "BreakingNewsFragment"

override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
super.onViewCreated(view, savedInstanceState)
viewModel = (activity as NewsActivity).viewModel
setupRecyclerView()

newsAdapter.setOnItemClickListener {
val bundle = Bundle().apply {
putSerializable("article", it)
}

findNavController().navigate(
R.id.action_breakingNewsFragment_to_articleFragment,
bundle
)
}

viewModel.breakingNews.observe(viewLifecycleOwner, Observer {response ->
when(response) {
is Resource.Success -> {
hideProgressBar()
response.data?.let {newsResponse ->
newsAdapter.differ.submitList(newsResponse.articles.toList())
val totalPages = newsResponse.totalResults / QUERY_PAGE_SIZE + 2
isLastPage = viewModel.breakingNewsPage == totalPages

if(isLastPage) {
rvBreakingNews.setPadding(0,0,0,0)
}

}
}

is Resource.Error -> {
hideProgressBar()
response.message?.let {message ->
Toast.makeText(activity, "An Error Occurred: $message", Toast.LENGTH_LONG).show()
}
}

is Resource.Loading -> {
showProgressBar()
}
}

})


}

private fun hideProgressBar() {
paginationProgressBar.visibility = View.INVISIBLE
isLoading = false
}
private fun showProgressBar() {
paginationProgressBar.visibility = View.VISIBLE
isLoading = true
}

**/