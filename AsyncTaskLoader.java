//Change the mainactivity to extend(inherit) LoaderManager.LoaderCallbacks<>	for example:
//public class EarthquakeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Earthquake>>


//EarthquakeActivity.java
LoaderManager loaderManager = getLoaderManager();
loaderManager.initLoader(0,null,this);   //Use these 2 lines to initialize the loader

public Loader<List<Earthquake>> onCreateLoader(int id, Bundle args) {
	return new EarthquakeLoader(this,USGS_REQUEST_URL);
}
public void onLoadFinished(Loader<List<Earthquake>> loader, List<Earthquake> earthquakes) {
	mAdapter.clear();
	if (earthquakes != null && !earthquakes.isEmpty()) {
		mAdapter.addAll(earthquakes);
	}
}
public void onLoaderReset(Loader<List<Earthquake>> loader) {
	mAdapter.clear();
}


//EarthquakeLoader.java
import android.content.AsyncTaskLoader;     //Import this only and nothing else
//The main class will extend(inherit) AsyncTaskLoader<>		for example:
//public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>>      

private String mUrl;
public EarthquakeLoader(@NonNull Context context, String url) {
	super(context);
	mUrl = url;
}
protected void onStartLoading() {
	forceLoad();
}
public List<Earthquake> loadInBackground() {
	List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
	return earthquakes;
}