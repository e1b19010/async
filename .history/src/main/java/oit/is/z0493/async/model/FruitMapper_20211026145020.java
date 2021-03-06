package oit.is.z0493.async.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface FruitMapper {

  @Select("SELECT ID, NAME,PRICE FROM FRUIT")
  ArrayList<Fruit> selectAllFruit();

}
