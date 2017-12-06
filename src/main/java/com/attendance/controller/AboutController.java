package com.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Tobitoi on 12/6/17.
 */
@Controller
public class AboutController {
    @RequestMapping("/about")
    public String about (Model model ){
        model.addAttribute("aboutsp1","Makassar Container Terminal is one of the core business segments in PT Pelabuhan Indonesia IV (Persero). On August 1, 2007 Makassar Container Terminal has been declared service of PT Pelabuhan Indonesia IV especially related to service of container along with the growth of containerization through Makassar Port.");
        model.addAttribute("aboutsp2","Basically, Makassar Container Terminal service is oriented to several basic policies, namely: cost efficiency, time effectiveness, and also customer satisfaction as embodied in the company's vision and mission in facing the ever-changing global competition world.");
        model.addAttribute("aboutsp3","In its effort to provide satisfaction to customers, Makassar Container Terminal continues to improve the quality of service by implementing quality policy that is \"Service with punctuality, security, and trusted\" with international standard.");
        model.addAttribute("aboutsp4","The development of quality of container terminal services is also supported by the availability of modern facilities and equipment, as well as high quality human resources capable of providing fast, precise and safe service. In addition, the implementation of the international standardized and compounded system is also a key factor in improving the quality of Makassar Container Terminal service.");
        model.addAttribute("headingVisi","VISI COMPANY");
        model.addAttribute("descVisi","Being a valuable and high-tech company through superior processes and services with happy people.");
        model.addAttribute("headingMisi","MISI COMPANY");
        model.addAttribute("descMisi1","1. Becoming  a driver of economic growth in Central and Eastern Indonesia");
        model.addAttribute("descMisi2", "2. Providing a High Level of Customer Satisfaction");
        model.addAttribute("descMisi3","3. Level of Customer Satisfaction And Employee Attachment Increasing");
        model.addAttribute("descMisi4","4. Become a Trusted and Profitable Business Partner");
        model.addAttribute("descMisi5","5. Revenue Growth and Operating Profit 20% Every Year");
        model.addAttribute("descMisi6","6. Become Public Company Year 2018");
        model.addAttribute("headingTpm","TERMINAL PETIKEMAS MAKASSAR");

        return "about";

    }
}
