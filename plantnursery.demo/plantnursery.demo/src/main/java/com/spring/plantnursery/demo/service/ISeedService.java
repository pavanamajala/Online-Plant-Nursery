package com.spring.plantnursery.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.spring.plantnursery.demo.entity.Seed;
import com.spring.plantnursery.demo.repository.ISeedRepository;

@Service
public class ISeedService {
	
	@Autowired
	private ISeedRepository isr;
	public Seed addSeed(Seed seed) {
		return isr.save(seed);
	}
	public Seed updateSeed(Seed seed) {
		int seedId=seed.getSeedId();
		Optional<Seed> opt=isr.findById(seedId);
		if(opt.isPresent()) {
			Seed old=opt.get();
			old.setBloomTime(seed.getBloomTime());
			old.setCommonName(seed.getCommonName());
			old.setDifficultyLevel(seed.getDifficultyLevel());
			old.setSeedDescription(seed.getSeedDescription());
			old.setSeedId(seed.getSeedId());
			old.setSeedsCost(seed.getSeedsCost());
			old.setSeedsPerPacket(seed.getSeedsPerPacket());
			old.setTemperature(seed.getTemperature());
			old.setTypeOfSeed(seed.getTypeOfSeed());
			old.setSeedsStock(seed.getSeedsStock());
			old.setWatering(seed.getWatering());
			return isr.save(old);
		} else {
			return isr.save(seed);
		}
	}
//	public Seed deleteSeed(Seed seed) {
//		int seedId=seed.getSeedId();
//		Optional<Seed> opt=isr.findById(seedId);
//		if(opt.isPresent()) {
//			Seed old=opt.get();
//			isr.delete(old);
//			return old;
//		} else {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Seed Is Not Found");
//		}
//	}
	public Optional<Seed> viewSeed(int seedId) {
		return isr.findById(seedId);
	}
//	public Seed viewSeed(String commonName) {
//		List<Seed> seed=isr.findAll();
//		for(int i=0;i<seed.size();i++) {
//			if(seed.get(i).getCommonName().equals(commonName)) {
//				return seed.get(i);
//			} 
//		}
//		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"commonName Is Not Found");
//	}
	public List<Seed> viewAllSeeds(){
		return isr.findAll();
	}
//	public List<Seed> viewAllSeeds(String typeOfSeed){
//		List<Seed> seed=isr.findAll();
//		for(int i=0;i<seed.size();i++) {
//			if(!(seed.get(i).getTypeOfSeed().equals(typeOfSeed))) {
//				seed.remove(i);
//			}
//		}
//		return seed;
//	}
	public Seed deleteSeed(int id) {
		Optional<Seed> opt=isr.findById(id);
		if(opt.isPresent()) {
			Seed old=opt.get();
			isr.delete(old);
			return old;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Seed Is Not Found");
		}
	}
}
