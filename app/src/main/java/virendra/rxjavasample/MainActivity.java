package virendra.rxjavasample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //(1)create list
        List<String> list = Arrays.asList("Android", "Ubuntu", "Mac OS");
        //(Create observables)
        Observable<List<String>> listObservable = Observable.just(list);
        //(Register the observable)
        listObservable.subscribe(new Observer<List<String>>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(List<String> value) {
                System.out.println("Value:" + value);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Error:" + e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }
        });
    }
}
