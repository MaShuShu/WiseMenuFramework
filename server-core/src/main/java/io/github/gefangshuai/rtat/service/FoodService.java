package io.github.gefangshuai.rtat.service;

import io.github.gefangshuai.ext.persistence.CoreService;
import io.github.gefangshuai.rtat.dao.FoodDao;
import io.github.gefangshuai.rtat.model.Food;
import io.github.gefangshuai.rtat.model.FoodType;
import io.github.gefangshuai.rtat.model.Restaurant;
import io.github.gefangshuai.utils.ImageUtils;
import io.github.gefangshuai.utils.StoreUtils;
import org.im4java.core.IM4JavaException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by gefangshuai on 2015/11/13.
 */
@Service
@Transactional(readOnly = true)
public class FoodService extends CoreService<Food, Long> {

    private FoodDao foodDao;

    @Resource
    public void setFoodDao(FoodDao foodDao) {
        this.foodDao = foodDao;
        super.coreDao = foodDao;
    }


    /**
     * 根据餐厅和名称查询
     * @param restaurant 餐馆
     * @param name 菜品
     * @param page 分页
     * @return
     */
    public Page<Food> findByRestaurantAndNameLike(Restaurant restaurant, String name, Pageable page) {
        return foodDao.findByRestaurantAndNameLike(restaurant, name, page);
    }

    /**
     * 根据餐厅、分类和名称查询
     * @param restaurant 餐馆
     * @param foodType 分类
     * @param name 名称
     * @param page 分页
     * @return
     */
    public Page<Food> findByRestaurantAndFoodTypeAndNameLike(Restaurant restaurant, FoodType foodType, String name, Pageable page){
        return foodDao.findByRestaurantAndFoodTypeAndNameLike(restaurant, foodType, name, page);
    }

    public List<Food> findPublishedByRestaurantAndType(Restaurant restaurant, FoodType foodType){
        return foodDao.findByPublishedAndRestaurantAndFoodType(true, restaurant, foodType);
    }


    public List<Food> findPublishedByRestaurant(Restaurant restaurant) {
        return foodDao.findByPublishedAndRestaurant(true, restaurant);
    }

    @Transactional
    public void rebuildThumb(String root, String graphicsMagickHome) throws InterruptedException, IOException, IM4JavaException {
        List<Food> foods = foodDao.findAll();
        for (Food food : foods) {
            String path = root + food.getImagePath();
            String target = StoreUtils.getThumbPath(path);
            ImageUtils.compress(graphicsMagickHome, path, target, "120");
            food.setThumbPath(StoreUtils.getThumbPath(food.getImagePath()));
            save(food);
        }
    }

    public List<Food> listByIds(Long[] ids) {
        return foodDao.findByIds(ids);
    }
}
