package ucm.onlinedvdstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ucm.onlinedvdstore.bean.DVDBean;
import ucm.onlinedvdstore.model.DVDModel;
import ucm.onlinedvdstore.repository.DVDRepository;


@Controller
public class OnlineDVDStoreController {
	
	 private static Logger logger = Logger.getLogger(OnlineDVDStoreController.class);
	 
	 @Autowired
	 private DVDRepository repo;
	 
	@RequestMapping("/")
	  public String homepage2(ModelMap model, HttpServletRequest request, HttpServletResponse response){
	    logger.info("index.jsp populated");
	    return "index";
	  }
	
	 
	 
	 @RequestMapping(value="/welcome", method = RequestMethod.GET)
	 public ModelAndView welcome() throws Exception {
		 repo.indexDVDS();
		 ModelAndView modelandview  =  new ModelAndView("hello");
		 modelandview.addObject("message", "HelloWorld!");
		 return modelandview;
	 }
	 
	 @RequestMapping(value="/insertDVD", method = RequestMethod.GET)
	 public ModelAndView insertDVDPage(){
		 ModelAndView mav = new ModelAndView("insertDVD", "command", new DVDModel());
	      return mav;
	 }
	 
	 @RequestMapping(value="/insertDVDToDB", method = RequestMethod.POST)
	 public ModelAndView insertDVDToDB(@ModelAttribute("DVDModel") DVDModel dvdModel) throws Exception{
		 logger.info(dvdModel.getId());
		 logger.info(dvdModel.getDvdCategory());
		 logger.info(dvdModel.getDvdName());
		 logger.info(dvdModel.getDvdPrice());
		 logger.info(dvdModel.getDvdDescription());
		 logger.info(dvdModel.getImagePath());
		 
		 repo.insertDVDToDB(dvdModel.getId(), dvdModel.getDvdCategory(), dvdModel.getDvdName(), dvdModel.getDvdDescription(),
				 dvdModel.getDvdPrice(), dvdModel.getImagePath());
		 ModelAndView mav = new ModelAndView("done");
	      mav.addObject("message", "Add DVD  to DB successfully");
	      return mav;
		 
	 }
	 
 @RequestMapping(value = "/search", method = RequestMethod.GET)
	   public ModelAndView searchPage()
	   {
	      ModelAndView mav = new ModelAndView("search");
	      return mav;
	   }
	 @RequestMapping(value = "/doSearch", method = RequestMethod.POST)
	 public ModelAndView search(
			 				@RequestParam("searchText")
			 				String searchText
			 				) throws Exception
	 {		
		// List<DVDBean> allFound = repo.getDVDList(searchText);
		 List<DVDBean> allFound = repo.searchDVD(searchText);
		 
		 List<DVDModel> dvdModels = new ArrayList<DVDModel>();
		 for(DVDBean dvd : allFound){
			 DVDModel dvdModel = new DVDModel();
			 dvdModel.setId(dvd.getId());
			 dvdModel.setDvdCategory(dvd.getDvdCategory());
			 dvdModel.setDvdName(dvd.getDvdName());
			 dvdModel.setDvdDescription(dvd.getDvdDescription());
			 dvdModel.setDvdPrice(dvd.getDvdPrice());
			 dvdModel.setImagePath(dvd.getImagePath());
			 
			 dvdModels.add(dvdModel);
			 logger.info("dvd list in controller" +dvdModels);
		 }
		 ModelAndView mav = new ModelAndView("foundDVDS");
		 mav.addObject("foundDVDS",dvdModels);
		 return mav;
	 }
	 
}
