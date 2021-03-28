package com.example.segmented.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            String sol =null;
            switch (input){
                case 1:
                    sol= "Pantalla principal: reloj actual";
                    break;
                case 2:
                    sol= "Pantalla lista de relojes: clicar en un reloj existente para editar";
                    break;
                case 3:
                    sol= "creador de relojes";
                    break;
                default:
                    sol= "npi";
                    break;
            }
            //return "Hello world from section: " + input;
            return sol;
        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }
}