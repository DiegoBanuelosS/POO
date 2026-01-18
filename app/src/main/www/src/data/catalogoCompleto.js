export const catalogoCompleto = [
  // Deportivos
  {
    id: 1,
    nombre: "Lamborghini Temerario",
    tipo: "Super Deportivo Híbrido",
    precio: "$8,000,000",
    categoria: "hibrido",
    descripcion: "El Temerario representa la nueva era de los superdeportivos de Lamborghini, combinando un motor V8 híbrido con tecnología de punta.",
    especificaciones: {
      motor: "V8 4.0L Twin-Turbo Híbrido",
      potencia: "920 HP",
      velocidadMaxima: "340 km/h",
      aceleracion: "2.7 segundos (0-100 km/h)",
      transmision: "Automática de 8 velocidades"
    },
    media: [
      { tipo: "imagen", url: "https://www.lamborghini.com/sites/it-en/files/DAM/lamborghini/0_facelift_2025/model_details/temerario/2025/07_29_refresh/Exterior.jpg" },
      { tipo: "video", url: "https://www.lamborghini.com/sites/it-en/files/DAM/lamborghini/facelift_2024/homepage/temerario/26-02/Lambo_Temerario_TeaserCampaign.mp4" },
      { tipo: "imagen", url: "https://www.lamborghini.com/sites/it-en/files/DAM/lamborghini/0_facelift_2025/model_details/temerario/2025/07_29_refresh/Interior.jpg" },
      { tipo: "imagen", url: "https://www.lamborghini.com/sites/it-en/files/DAM/lamborghini/facelift_2024/model_detail/temerario/s/07-03/temerario_s_01.jpg" }
    ],
    disponible: true,
    año: 2024
  },
  {
    id: 2,
    nombre: "Ferrari F8 Tributo",
    tipo: "Super Deportivo",
    precio: "$12,000,000",
    categoria: "deportivo",
    descripcion: "Homenaje al motor V8 más potente de Ferrari, el F8 Tributo ofrece un rendimiento excepcional y un diseño icónico.",
    especificaciones: {
      motor: "V8 3.9L Twin-Turbo",
      potencia: "720 HP",
      velocidadMaxima: "340 km/h",
      aceleracion: "2.9 segundos (0-100 km/h)",
      transmision: "Automática DCT de 7 velocidades"
    },
    imagenes: [
      "https://di-uploads-pod1.dealerinspire.com/newcountryferrariofnaples/uploads/2020/12/tributo.jpg",
      "https://cdn.ferrari.com/cms/network/media/img/resize/5d273eaac3f9ec0af647561e-d-interior-1920x1200?width=1920&height=1080",
      "https://cdn.ferrari.com/cms/network/media/img/resize/5d2716951fa28c0ad2ec169e-d-design-3500x2188_bjv8mfwb",
      "https://cdn.ferrari.com/cms/network/media/img/resize/5d2710e77e98e13abbbecf73-d-aerodinamica-3500x2188"
    ],
    disponible: true,
    año: 2023
  },
  {
    id: 3,
    nombre: "Bugatti Tourbillon",
    tipo: "Hyper Deportivo Híbrido",
    precio: "$78,800,000",
    categoria: "hibrido",
    descripcion: "La nueva cumbre de la ingeniería automotriz, el Tourbillon redefine los límites del rendimiento y el lujo.",
    especificaciones: {
      motor: "V16 8.3L + 3 Motores Eléctricos",
      potencia: "1,800 HP",
      velocidadMaxima: "445 km/h",
      aceleracion: "2.0 segundos (0-100 km/h)",
      transmision: "Automática DCT de 8 velocidades"
    },
    imagenes: [
      "https://bugatti.imgix.net/67475f22a32ff125e1a83414/tourbillon-modelpage-studio-25_crop2.jpg",
      "https://bugatti.imgix.net/67475b1ca32ff125e1a83242/tourbillon-modelpage-studio-28.jpg?auto=format,compress&cs=srgb&sharp=10&fit=crop&ar=4:5&h=1074&fp-x=0.5&fp-y=0.5&dpr=1",
      "https://bugatti.imgix.net/67475f3fa32ff125e1a8341a/tourbillon-modelpage-studio-29_crop2.jpg?auto=format,compress&cs=srgb&sharp=10&fit=crop&ar=4:5&h=512&fp-x=0.16&fp-y=0.51&dpr=1",
      "https://bugatti.imgix.net/67478249a32ff125e1a86089/tourbillon-modelpage-presskit-31.jpg?auto=format,compress&cs=srgb&sharp=10&w=798&dpr=1"
    ],
    disponible: true,
    año: 2024
  },
  {
    id: 4,
    nombre: "Porsche 911 GT3 RS",
    tipo: "Deportivo",
    precio: "$5,500,000",
    categoria: "deportivo",
    descripcion: "El máximo exponente del 911, diseñado para la pista pero legal para la calle.",
    especificaciones: {
      motor: "Flat-6 4.0L",
      potencia: "525 HP",
      velocidadMaxima: "296 km/h",
      aceleracion: "3.2 segundos (0-100 km/h)",
      transmision: "Automática PDK de 7 velocidades"
    },
    imagenes: [
      "https://images-porsche.imgix.net/-/media/D41AD8E7D55E45BDA5CFE8651F497A74_145CD2F719DF4CC88352C7DC0B71C560_CZ23V20OX0038-911-gt3-rs-side?w=2560&h=1440&q=85&crop=faces%2Centropy%2Cedges&auto=format",
      "https://images-porsche.imgix.net/-/media/140DC70EEA774F5493D80DAD0500F81E_45AD9E3761584BDD98B3FF5D53D09CEB_CZ23V20OX0020-911-gt3-rs-front-with-driver?w=300&q=85&crop=faces%2Centropy%2Cedges&auto=format 300w,https://images-porsche.imgix.net/-/media/140DC70EEA774F5493D80DAD0500F81E_45AD9E3761584BDD98B3FF5D53D09CEB_CZ23V20OX0020-911-gt3-rs-front-with-driver?w=600&q=85&crop=faces%2Centropy%2Cedges&auto=format 600w,https://images-porsche.imgix.net/-/media/140DC70EEA774F5493D80DAD0500F81E_45AD9E3761584BDD98B3FF5D53D09CEB_CZ23V20OX0020-911-gt3-rs-front-with-driver?w=900&q=85&crop=faces%2Centropy%2Cedges&auto=format 900w,https://images-porsche.imgix.net/-/media/140DC70EEA774F5493D80DAD0500F81E_45AD9E3761584BDD98B3FF5D53D09CEB_CZ23V20OX0020-911-gt3-rs-front-with-driver?w=1200&q=85&crop=faces%2Centropy%2Cedges&auto=format 1200w,https://images-porsche.imgix.net/-/media/140DC70EEA774F5493D80DAD0500F81E_45AD9E3761584BDD98B3FF5D53D09CEB_CZ23V20OX0020-911-gt3-rs-front-with-driver?w=1500&q=85&crop=faces%2Centropy%2Cedges&auto=format 1500w,https://images-porsche.imgix.net/-/media/140DC70EEA774F5493D80DAD0500F81E_45AD9E3761584BDD98B3FF5D53D09CEB_CZ23V20OX0020-911-gt3-rs-front-with-driver?w=1800&q=85&crop=faces%2Centropy%2Cedges&auto=format 1800w,https://images-porsche.imgix.net/-/media/140DC70EEA774F5493D80DAD0500F81E_45AD9E3761584BDD98B3FF5D53D09CEB_CZ23V20OX0020-911-gt3-rs-front-with-driver?w=2100&q=85&crop=faces%2Centropy%2Cedges&auto=format 2100w,https://images-porsche.imgix.net/-/media/140DC70EEA774F5493D80DAD0500F81E_45AD9E3761584BDD98B3FF5D53D09CEB_CZ23V20OX0020-911-gt3-rs-front-with-driver?w=2400&q=85&crop=faces%2Centropy%2Cedges&auto=format 2400w,https://images-porsche.imgix.net/-/media/140DC70EEA774F5493D80DAD0500F81E_45AD9E3761584BDD98B3FF5D53D09CEB_CZ23V20OX0020-911-gt3-rs-front-with-driver?w=2560&q=85&crop=faces%2Centropy%2Cedges&auto=format 2560w",
      "https://images-porsche.imgix.net/-/media/8377BED4CA1F4B95AC0AEFBDE2FDF62F_54F75BDBFDDA4013AD6FDBF651F13480_CZ23V20OX0001-911-gt3-rs-rear-desktop?w=999&ar=16%3A9&q=85&auto=format",
      "https://images-porsche.imgix.net/-/media/F41DFC33F9A8497FBC6FD9576CDC867B_DC18F259E8EC49C79BFBBA86EEB98A31_CZ23V20OX0023-911-gt3-rs-rear?w=1759&q=85&auto=format"
    ],
    disponible: true,
    año: 2024
  },
  {
    id: 5,
    nombre: "McLaren 720S",
    tipo: "Super Deportivo",
    precio: "$6,800,000",
    categoria: "deportivo",
    descripcion: "Aerodinámica extrema y rendimiento sin concesiones en el superdeportivo británico.",
    especificaciones: {
      motor: "V8 4.0L Twin-Turbo",
      potencia: "720 HP",
      velocidadMaxima: "341 km/h",
      aceleracion: "2.8 segundos (0-100 km/h)",
      transmision: "Automática SSG de 7 velocidades"
    },
    imagenes: [
      "https://website-images.mclaren.com/4999/mclaren-legacy-720s-hero-mobile.png",
      "https://website-images.mclaren.com/1347/mclaren-720s-steering-wheel.jpg",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQc7Ur57z3rAsDCzWAF-yqkWb6CDgj6SMvIag&s",
      "https://preowned-eu.mclaren.com/picserver1/userdata/1/37140/WofUuhdoBr/xxl_kfz107040258_0000.jpg"
    ],
    disponible: true,
    año: 2023
  },
  
  // SUVs
  {
    id: 6,
    nombre: "Lamborghini Urus SE",
    tipo: "SUV Deportivo Híbrido",
    precio: "$4,800,000",
    categoria: "hibrido",
    descripcion: "El primer Super SUV híbrido enchufable del mundo, combina la practicidad de un SUV con el alma de un superdeportivo.",
    especificaciones: {
      motor: "V8 4.0L Twin-Turbo + Motor Eléctrico",
      potencia: "800 HP",
      velocidadMaxima: "312 km/h",
      aceleracion: "3.4 segundos (0-100 km/h)",
      transmision: "Automática de 8 velocidades"
    },
    imagenes: [
      "https://www.lamborghini.com/sites/it-en/files/DAM/lamborghini/model/URUS/URUS%20SE/EXTERIOR_URUS_SE.jpg",
      "https://www.lamborghini.com/sites/it-en/files/DAM/lamborghini/0_facelift_2025/model_details/urus_se/Interior.jpg",
      "https://www.lamborghini.com/sites/it-en/files/DAM/lamborghini/0_facelift_2025/model_details/urus_se/gallery1-desktop.jpg",
      "https://www.lamborghini.com/sites/it-en/files/DAM/lamborghini/0_facelift_2025/model_details/urus_se/feeltheengine-desktop.jpg"
    ],
    disponible: true,
    año: 2024
  },
  {
    id: 7,
    nombre: "Bentley Bentayga",
    tipo: "SUV Luxury",
    precio: "$4,200,000",
    categoria: "suv",
    descripcion: "El SUV de lujo definitivo, con artesanía británica y rendimiento excepcional.",
    especificaciones: {
      motor: "V8 4.0L Twin-Turbo",
      potencia: "550 HP",
      velocidadMaxima: "290 km/h",
      aceleracion: "4.5 segundos (0-100 km/h)",
      transmision: "Automática de 8 velocidades"
    },
    imagenes: [
      "https://www.bentleymotors.com/content/dam/bm/websites/bmcom/bentleymotors-com/models/25my/atelier-edition/Gallery%201.1.jpg/_jcr_content/renditions/original.image_file.1332.749.file/Gallery%201.1.jpg",
      "https://www.bentleymotors.com/content/dam/bm/websites/bmcom/bentleymotors-com/models/24my/bentayga-swb/bentayga-swb-range-page/SWB%20Range%20Accessories.jpg/_jcr_content/renditions/original.image_file.1074.1432.file/SWB%20Range%20Accessories.jpg"
    ],
    disponible: true,
    año: 2024
  },
  {
    id: 8,
    nombre: "Range Rover Sport SV",
    tipo: "SUV Premium",
    precio: "$3,500,000",
    categoria: "suv",
    descripcion: "Lujo británico y capacidades todoterreno incomparables en una sola máquina.",
    especificaciones: {
      motor: "V8 4.4L Twin-Turbo",
      potencia: "635 HP",
      velocidadMaxima: "290 km/h",
      aceleracion: "3.8 segundos (0-100 km/h)",
      transmision: "Automática de 8 velocidades"
    },
    imagenes: [
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwIyqMCgUQNFqrqwtfU9unckYgONuor8RCWw&s",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7ikAaunI_VwH8l_3zk5TJ4aaTc75T-eYjBQ&s",
      "https://e01-expansion.uecdn.es/assets/multimedia/imagenes/2024/05/03/17147282281754.jpg",
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXaF_411E67COoJ9AaagFBHkZc7YpB3n7hRg&s"
    ],
    disponible: true,
    año: 2024
  },
  {
    id: 9,
    nombre: "Aston Martin DBX 707",
    tipo: "SUV Deportivo",
    precio: "$4,500,000",
    categoria: "suv",
    descripcion: "El SUV más potente de Aston Martin, donde elegancia y performance se encuentran.",
    especificaciones: {
      motor: "V8 4.0L Twin-Turbo",
      potencia: "707 HP",
      velocidadMaxima: "310 km/h",
      aceleracion: "3.3 segundos (0-100 km/h)",
      transmision: "Automática de 9 velocidades"
    },
    imagenes: [
      "https://www.astonmartin.com/-/media/models---dbx707/dbx707-25my---november-2024-refresh/dbx707_low_res_24_desktop_hero_1920x1080.jpg?mw=1920&rev=6c89f0c39b3d4b47b924915a01ec73b2&extension=webp&hash=939CF8C53962B63D4EFE6EEA98578EBE",
      "https://www.astonmartin.com/-/media/models---dbx707/dbx707-25my---november-2024-refresh/interior/scrollable/dbx-interior-scrollable-alt.jpg?rev=caa177750bbf44c3b481f93ffca9d996&extension=webp",
      "https://www.astonmartin.com/-/media/brand-stories/carplay-2/model-page-updates-1405/dbx707-environment-tile-new.jpg?mw=1920&rev=e76cd728570644128bfd05ab5a078fd6&extension=webp&hash=169C64AEEC2C29502951143771343A44",
      "https://www.astonmartin.com/-/media/models---dbx707/dbx707-25my---november-2024-refresh/exterior/tiles/dbx-rear-tile-2.jpg?mw=1920&rev=77f2fe84e8a9404583bc8795bfe94756&extension=webp&hash=199F846D034DB1360CFE63CFB74A1F50"
    ],
    disponible: true,
    año: 2024
  },
  
  // Sedanes
  {
    id: 10,
    nombre: "Rolls Royce Spectre",
    tipo: "Sedan Eléctrico",
    precio: "$6,500,000",
    categoria: "sedan",
    descripcion: "El primer Rolls-Royce totalmente eléctrico, una obra maestra de lujo y tecnología.",
    especificaciones: {
      motor: "Dual Motor Eléctrico",
      potencia: "584 HP",
      velocidadMaxima: "250 km/h",
      aceleracion: "4.5 segundos (0-100 km/h)",
      autonomia: "520 km"
    },
    imagenes: [
      "https://www.rolls-roycemotorcars.com/content/dam/rrmc/marketUK/rollsroycemotorcars_com/spectre-discover/page-components/comp-update-dec-24/D-HERO-SPECTRE-DISCOVER%20(1).jpg/jcr:content/renditions/cq5dam.web.2880.webp",
      "https://www.rolls-roycemotorcars.com/content/dam/rrmc/marketUK/rollsroycemotorcars_com/spectre-discover/page-components/comp-update-dec-24/D-IMAGE-SPECTRE-DISCOVER%20(2).jpg/jcr:content/renditions/cq5dam.web.2880.webp 2880w, /content/dam/rrmc/marketUK/rollsroycemotorcars_com/spectre-discover/page-components/comp-update-dec-24/D-IMAGE-SPECTRE-DISCOVER%20(2).jpg/jcr:content/renditions/cq5dam.web.1242.webp 1242w, /content/dam/rrmc/marketUK/rollsroycemotorcars_com/spectre-discover/page-components/comp-update-dec-24/D-IMAGE-SPECTRE-DISCOVER%20(2).jpg/jcr:content/renditions/original 3840w, /content/dam/rrmc/marketUK/rollsroycemotorcars_com/spectre-discover/page-components/comp-update-dec-24/D-IMAGE-SPECTRE-DISCOVER%20(2).jpg/jcr:content/renditions/cq5dam.web.1920.webp 1920w, /content/dam/rrmc/marketUK/rollsroycemotorcars_com/spectre-discover/page-components/comp-update-dec-24/D-IMAGE-SPECTRE-DISCOVER%20(2).jpg/jcr:content/renditions/cq5dam.web.828.webp 828w",
      "https://www.rolls-roycemotorcars.com/content/dam/rrmc/marketUK/rollsroycemotorcars_com/spectre-discover/page-components/comp-update-dec-24/D-IMAGE-STACK-SPECTRE-DISCOVER.png/jcr:content/renditions/cq5dam.web.2880.webp 2880w, /content/dam/rrmc/marketUK/rollsroycemotorcars_com/spectre-discover/page-components/comp-update-dec-24/D-IMAGE-STACK-SPECTRE-DISCOVER.png/jcr:content/renditions/cq5dam.web.1242.webp 1242w, /content/dam/rrmc/marketUK/rollsroycemotorcars_com/spectre-discover/page-components/comp-update-dec-24/D-IMAGE-STACK-SPECTRE-DISCOVER.png/jcr:content/renditions/original 3840w, /content/dam/rrmc/marketUK/rollsroycemotorcars_com/spectre-discover/page-components/comp-update-dec-24/D-IMAGE-STACK-SPECTRE-DISCOVER.png/jcr:content/renditions/cq5dam.web.1920.webp 1920w, /content/dam/rrmc/marketUK/rollsroycemotorcars_com/spectre-discover/page-components/comp-update-dec-24/D-IMAGE-STACK-SPECTRE-DISCOVER.png/jcr:content/renditions/cq5dam.web.828.webp 828w",
      "https://www.rolls-roycemotorcars.com/content/dam/rrmc/marketUK/rollsroycemotorcars_com/spectre-discover/page-components/comp-update-dec-24/D-PAR-BLOCK-01-03-SPECTRE-DISOVER.jpg/jcr:content/renditions/cq5dam.web.1920.webp"
    ],
    disponible: true,
    año: 2024
  },
  {
    id: 11,
    nombre: "BMW M5 CS",
    tipo: "Sedan Deportivo",
    precio: "$2,800,000",
    categoria: "sedan",
    descripcion: "El M5 más extremo jamás creado, combinando lujo y rendimiento de pista.",
    especificaciones: {
      motor: "V8 4.4L Twin-Turbo",
      potencia: "635 HP",
      velocidadMaxima: "305 km/h",
      aceleracion: "3.0 segundos (0-100 km/h)",
      transmision: "Automática M Steptronic de 8 velocidades"
    },
    imagenes: [
      "https://prod.cosy.bmw.cloud/bmwweb/cosySec?COSY-EU-100-7331MkJEPuqTMI0nTNfIAnH7GRCPxh7slGAGwuCrXpFpoplZQ6K6mkXRaYWFR1Q5nmPKMRagOybWecnvIT9PS4O2B3ibMPIjedw9hdBDMztr%25oeqhk7ZnHMLoACRBmhJHFl5W6ou%25KXhBJHSfWQoS3%25V1PaHIGfNEbn%25BA10s9OfUvE4riI1L7scZwBEXdrxRtesCzZ857Mr2IRUgChZjR5GvloRUjgp2XH5Gzv6jQ%25g0t2YDafv42jmqn12JRDyLOEoNmqTJIsHRSL3uBr%25A3JdSeZfFpuzVMR1LXSkNh5ETCVA0og8j3NF4HvUbJ0Kc%252G9a4WxfjpiOcP81D6BAxbUEqY7F89GsLmYZUiprJyaBGw6ZuTAnptYRSaLR67m5VnbbYCygNO%25QmlTv0IjryX324BDpTQdjcekN3azDxzK6dnkq8kpYzOALUAZvkIFJGFHrABKupKY1FeWS6WmDKMPVYPegWhbNmbsnPox4qSN0enMA8iYj0Q53RpsBeayVOJx3w1pCRPmvhTAcIHFy2Dqgpn5oDgrvQFI%25lZyS4iqb4glR%25IzOSwNZxCRix2UT54ABNAigYx8tUDtmfgs7sYlvAEKCpLjNkMPoxOkBPpDSMA8iCzOSM5Z7pRix2l8xYCjPHWpcPQZE55Ga2LWD3gXAjHdcxv6ODCP5JCQYdqfR8cPCu1%25hJPLZf1EoKGOkDEgWi4UXg",
      "https://bmw.scene7.com/is/image/BMW/g90_technology_m-modes:3to2?fmt=webp&wid=2560&hei=1707",
      "https://bmw.scene7.com/is/image/BMW/g90_electric-driving_range:3to2?fmt=webp&wid=2560&hei=1707",
      "https://bmw.scene7.com/is/image/BMW/g90_charging-options_public-charging:3to2?fmt=webp&wid=2560&hei=1707"
    ],
    disponible: true,
    año: 2024
  },
  
  {
    id: 12,
    nombre: "Bentley Continental GT Speed",
    tipo: "Gran Turismo Luxury",
    precio: "$5,200,000",
    categoria: "luxury",
    descripcion: "El gran turismo definitivo, con artesanía exquisita y rendimiento sobrenatural.",
    especificaciones: {
      motor: "W12 6.0L Twin-Turbo",
      potencia: "659 HP",
      velocidadMaxima: "335 km/h",
      aceleracion: "3.6 segundos (0-100 km/h)",
      transmision: "Automática DCT de 8 velocidades"
    },
    imagenes: [
      "https://www.bentleymotors.com/content/dam/bm/websites/bmcom/bentleymotors-com/models/25my/25my-gt/Dynamic%20Stage%20Main%20v2.jpg/_jcr_content/renditions/original.image_file.1286.551.file/Dynamic%20Stage%20Main%20v2.jpg",
      "https://www.bentleymotors.com/content/dam/bm/websites/bmcom/bentleymotors-com/models/25my/25my-gt/Media%20Group%201.jpg/_jcr_content/renditions/original.image_file.1024.768.file/Media%20Group%201.jpg",
      "https://www.bentleymotors.com/content/dam/bm/websites/bmcom/bentleymotors-com/lifestyle-imagery/regression/GT%20Speed%20Media%20Group%202.jpg/_jcr_content/renditions/original.image_file.512.683.file/GT%20Speed%20Media%20Group%202.jpg",
      "https://www.bentleymotors.com/content/dam/bm/websites/bmcom/bentleymotors-com/models/26my/26my-gt-azure/GT%20Azure%20front%20interior%202%2016x9.jpg/_jcr_content/renditions/original.image_file.660.371.file/GT%20Azure%20front%20interior%202%2016x9.jpg"
    ],
    disponible: true,
    año: 2025
  },
  {
    id: 13,
    nombre: "Aston Martin DB12",
    tipo: "Gran Turismo Luxury",
    precio: "$4,900,000",
    categoria: "luxury",
    descripcion: "El super tourer definitivo de Aston Martin, combinando potencia y elegancia británica.",
    especificaciones: {
      motor: "V8 4.0L Twin-Turbo",
      potencia: "680 HP",
      velocidadMaxima: "325 km/h",
      aceleracion: "3.6 segundos (0-100 km/h)",
      transmision: "Automática de 8 velocidades"
    },
    imagenes: [
      "https://www.astonmartin.com/-/media/newmenunavigation/db12-couple-light.png?mw=1920&rev=91bfb99292c048de8ba14818e7d55f4d&extension=webp&hash=98FE553A43C3CA73A7D4B10B6FC09CFC",
      "https://www.astonmartin.com/-/media/models---db12/db12_hero_2-copy.jpg?mw=1920&rev=6f354a9adcf64b04b492f07453ff6c3a&extension=webp&hash=BA6E461B842C6E29E520C3265DB033FD",
      "https://www.astonmartin.com/-/media/models---db12/aug-2024-updates/scrollable-image-stills---engineering-desktop/engineering_still_desktop_db12_stills_ext_1201_front_7-8_dyn_rgb.jpg?rev=29cfb07596334c99b2bd3add2467da90&extension=webp",
      "https://www.astonmartin.com/-/media/models---db12/aug-2024-updates/scrollable-image-stills---interior-desktop/interior_still_image_desktop_20240829131206.jpg?rev=87cab56cdfb349d497f5167aa4000c88&extension=webp"
    ],
    disponible: true,
    año: 2024
  },
  {
    id: 14,
    nombre: "Rolls Royce Phantom",
    tipo: "Sedan Luxury",
    precio: "$8,500,000",
    categoria: "luxury",
    descripcion: "La cúspide del lujo automotriz, el Phantom representa lo mejor de Rolls-Royce.",
    especificaciones: {
      motor: "V12 6.75L Twin-Turbo",
      potencia: "571 HP",
      velocidadMaxima: "250 km/h",
      aceleracion: "5.3 segundos (0-100 km/h)",
      transmision: "Automática de 8 velocidades"
    },
    imagenes: [
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmsGt5ubFm5rG9Y62zVfIEjgLXcQieHJSj1A&s",
      "https://hips.hearstapps.com/hmg-prod/images/2026-rolls-royce-phantom-pr-121-690cd210611e9.jpg?crop=0.496xw:0.495xh;0.295xw,0.393xh&resize=1200:*",
      "https://hips.hearstapps.com/hmg-prod/images/2026-rolls-royce-phantom-pr-123-690cd211484fb.jpg?crop=0.553xw:0.554xh;0.106xw,0.344xh&resize=2048:*",
      "https://hips.hearstapps.com/hmg-prod/images/2026-rolls-royce-phantom-pr-110-690cd2795e766.jpg"
    ],
    disponible: true,
    año: 2024
  }
];

// Funciones auxiliares para filtrar el catálogo
export const obtenerPorCategoria = (categoria) => {
  return catalogoCompleto.filter(vehiculo => vehiculo.categoria === categoria);
};

export const obtenerPorId = (id) => {
  return catalogoCompleto.find(vehiculo => vehiculo.id === id);
};

export const obtenerDisponibles = () => {
  return catalogoCompleto.filter(vehiculo => vehiculo.disponible);
};

export const buscarVehiculos = (termino) => {
  const terminoLower = termino.toLowerCase();
  return catalogoCompleto.filter(vehiculo => 
    vehiculo.nombre.toLowerCase().includes(terminoLower) ||
    vehiculo.tipo.toLowerCase().includes(terminoLower) ||
    vehiculo.categoria.toLowerCase().includes(terminoLower)
  );
};
