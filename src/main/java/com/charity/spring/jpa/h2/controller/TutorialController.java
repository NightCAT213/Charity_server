package com.charity.spring.jpa.h2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.charity.spring.jpa.h2.model.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charity.spring.jpa.h2.repository.TutorialRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class TutorialController {

	@Autowired
	TutorialRepository tutorialRepository;

	@GetMapping("/cmaps")
	public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
		try {
			List<Tutorial> tutorials = new ArrayList<Tutorial>();

			if (title == null)
				tutorialRepository.findAll().forEach(tutorials::add);
			else
				tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/cmaps/{id}")
	public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
		Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/cmaps/{id}/title")
	public ResponseEntity<String> getTutorialTitleById(@PathVariable("id") long id) {
		ResponseEntity<String> res = ResponseEntity.ok().body(tutorialRepository.findById(id).get().getTitle());
		return res;
	}

	@GetMapping("/cmaps/{id}/desc")
	public ResponseEntity<String> getTutorialDescById(@PathVariable("id") long id) {
		ResponseEntity<String> res = ResponseEntity.ok().body(tutorialRepository.findById(id).get().getDescription());
		return res;
	}

	@GetMapping("/cmaps/{id}/address")
	public ResponseEntity<String> getTutorialAddressById(@PathVariable("id") long id) {
		ResponseEntity<String> res = ResponseEntity.ok().body(tutorialRepository.findById(id).get().getAddress());
		return res;
	}

	@GetMapping("/cmaps/{id}/c1")
	public ResponseEntity<Double> getTutorialC1ById(@PathVariable("id") long id) {
		ResponseEntity<Double> res = ResponseEntity.ok().body(tutorialRepository.findById(id).get().getCoords1());
		return res;
	}

	@GetMapping("/cmaps/{id}/c2")
	public ResponseEntity<Double> getTutorialC2ById(@PathVariable("id") long id) {
		ResponseEntity<Double> res = ResponseEntity.ok().body(tutorialRepository.findById(id).get().getCoords2());
		return res;
	}

	@GetMapping("/cmaps/{id}/pic")
	public ResponseEntity<String> getTutorialPictureById(@PathVariable("id") long id) {
		ResponseEntity<String> res = ResponseEntity.ok().body(tutorialRepository.findById(id).get().getPicture());
		return res;
	}

	/*@PostMapping("/cmaps")
	public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
		try {
			Tutorial _tutorial = tutorialRepository
					.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), tutorial.getAddress(),
							tutorial.getCoords1(), tutorial.getCoords2(), tutorial.getPhone()));
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/

	/*@PutMapping("/cmaps/{id}")
	public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
		Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

		if (tutorialData.isPresent()) {
			Tutorial _tutorial = tutorialData.get();
			_tutorial.setTitle(tutorial.getTitle());
			_tutorial.setDescription(tutorial.getDescription());
			_tutorial.setAddress(tutorial.getAddress());
			_tutorial.setCoords1(tutorial.getCoords1());
			_tutorial.setCoords2(tutorial.getCoords2());
			return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}*/

	/*@DeleteMapping("/cmaps/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			tutorialRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/

	/*@DeleteMapping("/cmaps")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			tutorialRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}*/

}
