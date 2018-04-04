package com.example.factorisation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.factorisation.model.GroupOfGoods;
import com.example.factorisation.service.GroupOfGoodsService;

@RestController
@RequestMapping(value = "/api/groupsOfGoods")
public class GroupOfGoodsController {

		@Autowired
		private GroupOfGoodsService groupOfGoodsService;

		@RequestMapping(value="getGroupsOfGoods", method = RequestMethod.GET)
		public ResponseEntity<List<GroupOfGoods>> getGroupsOfGoods() {

			List<GroupOfGoods> groupsOfGoods = groupOfGoodsService.findAll();

			return new ResponseEntity<>(groupsOfGoods, HttpStatus.OK);
		}

		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<GroupOfGoods> getGroupOfGoods(@PathVariable Long id) {
			GroupOfGoods groupOfGoods = GroupOfGoodsService.findOne(id);
			if (groupOfGoods == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<>(groupOfGoods, HttpStatus.OK);
		}

		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<GroupOfGoods> delete(@PathVariable Long id) {
			GroupOfGoods deleted = groupOfGoodsService.delete(id);

			return new ResponseEntity<>(deleted, HttpStatus.OK);
		}

		@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
		public ResponseEntity<GroupOfGoods> add(@RequestBody GroupOfGoods newGroupOfGoods) {

			GroupOfGoods savedGroupOfGoods = groupOfGoodsService.save(newGroupOfGoods);

			return new ResponseEntity<>(savedGroupOfGoods, HttpStatus.CREATED);
		}

		@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
		public ResponseEntity<GroupOfGoods> edit(@RequestBody GroupOfGoods groupOfGoods,
				@PathVariable Long id) {

			if (id != groupOfGoods.getId()) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			GroupOfGoods persisted = groupOfGoodsService.save(groupOfGoods);

			return new ResponseEntity<>(persisted, HttpStatus.OK);
		}
	
}
