package com.example.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	ResourceLoader resourceLoader;

	@PostMapping(value = "/versionCheck")
	public Map<String, Object> varCheck(@RequestBody RequestRespo req) throws FileNotFoundException, IOException {

		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			String csvPath = "C:\\WorkDir\\varCheck\\versionCheck.csv";

			FileReader filereader = new FileReader(csvPath);
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
			List<String[]> allData = csvReader.readAll();

			for (int i = 0; i < allData.size(); i++) {
				String[] row = allData.get(i);

				if (row[1].equalsIgnoreCase(req.getAppname()) && row[3].equalsIgnoreCase("1")) {
//					System.out.print(row[3] + "\t");
					Map<String, Object> rowData = new HashMap<String, Object>();
					rowData.put("apkname", row[0]);
					rowData.put("appname", row[1]); 
					rowData.put("apkver", row[2]);
					rowData.put("id", row[8]);
					rowData.put("forceupdate", row[6]);
					rowData.put("status", row[3]);

					resp.put("appname", row[1]);
					resp.put("errCode", "200");
					resp.put("errDes", "");
					resp.put("apkverion", rowData);
					resp.put("ts", new Date());
					resp.put("satus", true);
					return resp; 
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping(value = "/updateVersion")
	public Map<String, Object> updateVersion(@RequestBody RequestRespo req) throws FileNotFoundException, IOException {

		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			String csvPath = "C:\\WorkDir\\varCheck\\versionCheck.csv";

			FileReader filereader = new FileReader(csvPath);
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
			List<String[]> allData = csvReader.readAll();

			for (int i = 0; i < allData.size(); i++) {
				String[] row = allData.get(i);

				if (row[1].equalsIgnoreCase(req.getAppname()) && row[3].equalsIgnoreCase("1")) {
//					System.out.print(row[3] + "\t");
					Map<String, Object> rowData = new HashMap<String, Object>();
					rowData.put("apkname", row[0]);
					rowData.put("appname", row[1]); 
					rowData.put("apkver", row[2]);
					rowData.put("id", row[8]);
					rowData.put("forceupdate", row[6]);
					rowData.put("status", row[3]);

					resp.put("appname", row[1]);
					resp.put("errCode", "200");
					resp.put("errDes", "");
					resp.put("apkverion", rowData);
					resp.put("ts", new Date());
					resp.put("satus", true);
					return resp; 
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
