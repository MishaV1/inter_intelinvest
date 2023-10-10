/*
 * STRICTLY CONFIDENTIAL
 * TRADE SECRET
 * PROPRIETARY:
 *       "Intelinvest" Ltd, TIN 1655386205
 *       420107, REPUBLIC OF TATARSTAN, KAZAN CITY, SPARTAKOVSKAYA STREET, HOUSE 2, ROOM 119
 * (c) "Intelinvest" Ltd, 2019
 *
 * СТРОГО КОНФИДЕНЦИАЛЬНО
 * КОММЕРЧЕСКАЯ ТАЙНА
 * СОБСТВЕННИК:
 *       ООО "Интеллектуальные инвестиции", ИНН 1655386205
 *       420107, РЕСПУБЛИКА ТАТАРСТАН, ГОРОД КАЗАНЬ, УЛИЦА СПАРТАКОВСКАЯ, ДОМ 2, ПОМЕЩЕНИЕ 119
 * (c) ООО "Интеллектуальные инвестиции", 2019
 */

package ru.intelinvest.career.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.intelinvest.career.models.Stock;
import ru.intelinvest.career.service.MoexService;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/moex")
public class MoexEndpoint {

    private final MoexService moexService;

    public List<Stock> pagination(List<Stock> stocks, int size, int page){
        List<List<Stock>> lists = new ArrayList<>();
        List<Stock> list = new ArrayList<>();

        for(Stock stock : stocks){
            list.add(stock);

            if(list.size() == size){
                lists.add(new ArrayList<>(list));
                list = new ArrayList<>();
            }
        }
        if(list.size() < size && list.size() != 0) lists.add(new ArrayList<>(list));

        return lists.get(page);
    }

    @PostMapping("stocks")
    public ResponseEntity<List<Stock>> processIntegration(@RequestParam("levels") String levels,
                                                          @RequestParam("secids") String secids,
                                                          @RequestParam("num") int num,
                                                          @RequestParam("page") int page,
                                                          @RequestParam("size") int size) {
        var stocks = moexService.getStocks();
        // todo реализация задания № 2 и 3 здесь

        Set<String> levels_set = new HashSet<>(Arrays.asList(levels.split(",")));
        Set<String> secids_set = new HashSet<>(Arrays.asList(secids.split(",")));


        stocks = stocks.stream().filter((a) -> levels_set.contains(String.valueOf(a.getListlevel()))
                && secids_set.contains(a.getSecid())
                && a.getLotsize() == num).collect(Collectors.toList());


        if(size == 0) return ResponseEntity.ok(stocks);

        stocks = pagination(stocks, size, page);

        return ResponseEntity.ok(stocks);
    }

}
