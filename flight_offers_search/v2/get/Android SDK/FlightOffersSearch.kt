// How to install the library at https://github.com/amadeus4dev/amadeus-android

import com.amadeus.android.Amadeus
import com.amadeus.android.ApiResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import android.util.Log;

val job = SupervisorJob()
val scope = CoroutineScope(Dispatchers.Main + job)

val amadeus = Amadeus.Builder(context)
    .setClientId("REPLACE_BY_YOUR_API_KEY")
    .setClientSecret("REPLACE_BY_YOUR_API_SECRET")
    .build()

scope.launch {
  when (val flightOffersSearches = amadeus.shopping.flightOffersSearch.get(
                            originLocationCode = "SYD",
                            destinationLocationCode = "BKK",
                            departureDate = "2022-11-01",
                            returnDate ="2022-11-08",
                            adults = 2,
                            max = 3)) {
    is ApiResult.Success -> {
      Log.d("Result", "${result.data}")
    }
    is ApiResult.Error -> {
      // Handle your error
    }
  }
}
