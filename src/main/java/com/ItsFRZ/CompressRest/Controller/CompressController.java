package com.ItsFRZ.CompressRest.Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.ItsFRZ.CompressRest.Entity.DataModel;
import com.ItsFRZ.CompressRest.Repository.DataRepository;
import com.ItsFRZ.CompressRest.Service.DataService;


@Controller
public class CompressController {

	

	DataModel mod;
	byte[] sdata;
	
//	@Autowired
//	DataService service;
	
	@Autowired
	DataRepository repository;
	
	@GetMapping("/home")
	public String viewHomePage() 
	{
		
		return "addData";
	}
	
	@RequestMapping("/upload")
	public String saveData(@RequestParam("data") MultipartFile multipartFile,
			@RequestParam("id") long id) 
	{
		
		DataModel dataModel = new DataModel();
		dataModel.setId(id);
		dataModel.setName(multipartFile.getOriginalFilename());
		try {
			dataModel.setData(compressBytes(multipartFile.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String filename= multipartFile.getOriginalFilename();
		System.out.println("Object Name :- "+multipartFile.getOriginalFilename()+" Data Size Before Compression :- "+multipartFile.getSize());
		/*
		 * try { compressBytes(multipartFile.getBytes(),filename); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		
		repository.save(dataModel);
		
		
		return "addData";
	}
	
	@RequestMapping("download")
	public String viewData(ModelMap map) 
	{
		List<DataModel> dataModels = repository.findAll();
		map.addAttribute("allData", dataModels);
		
		return "downloadData";
	}
	

	
		
		// compress the data bytes before storing it in the database
			public static byte[] compressBytes(byte[] data) {
		    
		    	Deflater deflater = new Deflater();
		        deflater.setInput(data);
		        deflater.finish();
		        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		        byte[] buffer = new byte[1024];
		        while (!deflater.finished()) {
		            int count = deflater.deflate(buffer);
		            outputStream.write(buffer, 0, count);
		        }
		        try {
		            outputStream.close();
		        } catch (IOException e) {
		        }
//		        System.out.println("Object Name :- "+name+" Data Size After Compression :- "+outputStream.toByteArray().length);
		        
		        return outputStream.toByteArray();
		    }
			
			
			
			
			@RequestMapping("/downloadFile")
			public StreamingResponseBody downloadData(@RequestParam("id") long id,HttpServletResponse response) 
			{
				
				Optional<DataModel> model = repository.findById(id);
				if(model.isPresent()) {
					
					mod = model.get();
					sdata = decompressBytes(mod.getData());			
					response.setHeader("Content-Disposition", "");
					
				}
				
				return OutputStream -> {OutputStream.write(sdata);};

			}
				
			
		 // uncompress the data bytes before returning it to the frontend
		    public static byte[] decompressBytes(byte[] data) {
		        Inflater inflater = new Inflater();
		        inflater.setInput(data);
		        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		        byte[] buffer = new byte[1024];
		        try {
		            while (!inflater.finished()) {
		                int count = inflater.inflate(buffer);
		                outputStream.write(buffer, 0, count);
		            }
		            outputStream.close();
		        } catch (IOException ioe) {
		        } catch (DataFormatException e) {
		        }
		       return outputStream.toByteArray();
		    }
		    
	   
}
