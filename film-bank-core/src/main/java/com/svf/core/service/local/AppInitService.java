package com.svf.core.service.local;

import com.svf.core.entity.Film;
import com.svf.core.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/**
 * Created by stepanferubko
 */
@Service
public class AppInitService {
    private final Logger LOG = Logger.getLogger(AppInitService.class.getName());
    @Autowired
    private FilmRepository filmRepository;
//    @Autowired
//    private ModelMapper modelMapper;
//    @Autowired
//    private DictionaryClient dictionaryClient;

    public boolean initData() {
        LOG.info("Init data");
        LOG.info("Try to fill common dictionary...");
//        loadDictionary();

        LOG.info("Check all dictionary items...");
        try {
            checkDictionary();
        } catch (Exception e) {
            LOG.severe("Dicitionary checking error " + e);
        }
        return true;
    }

//    private void loadDictionary() {
//        try {
////            DictionaryResponse dictionaryResponse = dictionaryClient.listAll();
////            List<DictionaryDTO> items = dictionaryResponse.getItems();
//            LOG.info(items.size() + " dictionary items loaded from the common service");
//            Long saved = items.stream()
//                    .map(item -> modelMapper.map(item, Dictionary.class))
//                    .filter(item -> !dictionaryRepository.exists(item.getId()))
//                    .map(dictionaryRepository::save)
//                    .collect(Collectors.counting());
//            LOG.info(saved + " dictionary items saved to the local DB");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private boolean checkDictionary() {
        List<Film> all = filmRepository.findAll();
        AtomicInteger errorCounter = new AtomicInteger(0);
        AtomicInteger itemsChecked = new AtomicInteger(0);
        all.stream().forEach(d -> {
            try {
                itemsChecked.incrementAndGet();
//                dictionaryClient.findDictionaryItem(d.getId());
            } catch (Exception e) {
                LOG.severe(e.getMessage());
            }
        });
        LOG.warning("Saved films");
        return errorCounter.get() == 0;
    }
}
