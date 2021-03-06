Highly-collaborative distributed systems: synthesis and enactment at work
=======================
This repository contains the replication package of the paper we submitted to the journal [Concurrency and Computation: Practice and Experience](https://onlinelibrary.wiley.com/journal/15320634) with title ***Highly-collaborative distributed systems: synthesis and enactment at work***.

This work has been designed, developed, and reported by the following contributors:
 - [Marco Autili (University of L’Aquila)](mailto:marco.autili@univaq.it)
 - [Alexander Perucci (University of L’Aquila)](mailto:alexander.perucci@univaq.it)
 - [Leonardo Leite (University of São Paulo)](mailto:leofl@ime.usp.br)
 - [Massimo Tivoli (University of L’Aquila)](mailto:massimo.tivoli@univaq.it)
 - [Fabio Kon (University of São Paulo)](mailto:kon@ime.usp.br)
 - [Amleto Di Salle (University of L’Aquila)](mailto:amleto.disalle@univaq.it)

For any information, interested researchers can contact us by writing an email to any contributor listed above. A fully `documentation` can be found [here](https://sesygroup.github.io/choreography-synthesis-enactment).

The replication package can be downloaded [here](https://github.com/sesygroup/choreography-synthesis-enactment/archive/master.zip), and it is structured as follow:

| Folder                | Description  |
|-----------------------|--------------|
|  design-synthesis     | contains the BPMN2 `choreography` specification, the image of the choreography `architecture`, the choreography `deployment description`, the set of synthesized `coordination delegates`, and the set of selected `existing services` |
|  deployment-enactment | contains the artifacts necessary for `deploying` the synthesized coordination delegates and `enacting` the choreography |
|  execution-monitoring | contains the artefacts used to `execute` the experiment, the `monitor` used to analyze the extracted data, and the set of `monitoring data` |


```shell 
choreography-synthesis-enactment
|   pom.xml 'build all the projects'
|
+---design-synthesis
|   +---choreography
|   |      In-store Marketing and Sale - choreography specification.bpmn2
|   |      In-store Marketing and Sale - choreography specification.png
|   |
|   +---choreography-architecture
|   |      In-store Marketing and Sale - architecture.png
|   |
|   +---choreography-deployment
|   |      in-store-marketing-and-sale-chor-spec.xml
|   |
|   +---coordination-delegates
|   |   |   pom.xml 'build the coordination delegates'
|   |   |
|   |   +---CD-client-selfcheckoutmachine
|   |   +---CD-client-shopentrance
|   |   +---CD-client-smartcart
|   |   +---CD-marketingapplication-basiccommunicationdevice
|   |   +---CD-marketingapplication-instoretotem
|   |   +---CD-marketingapplication-marketingmanager
|   |   +---CD-marketingapplication-shoppingassistantapp
|   |   +---CD-marketingmanager-marketingapplication
|   |   +---CD-selfcheckoutmachine-marketingapplication
|   |   +---CD-selfcheckoutmachine-smartcart
|   |   +---CD-shopentrance-marketingapplication
|   |   +---CD-smartcart-selfcheckoutmachine
|   |   +---coordination-algorithm-wp7
|   |
|   \---existing-services
|       |   pom.xml 'build the existing services'
|       |
|       +---basiccommunicationdevice
|       +---client
|       +---instoretotem
|       +---marketingapplication
|       +---marketingmanager
|       +---selfcheckoutmachine
|       +---shopentrance
|       +---shoppingassistantapp
|       +---smartcart
|
+---deployment-enactment
|      clouds.properties
|      clouds.properties.experiment
|      ee.properties
|      qos_mgmt.properties
|    
\---execution-monitoring
    |   pom.xml 'build the monitor and the projects for executing the choreography'
    |
    +---choreography-instance-execution
    +---client-monitor
    +---execution-results 'extracted monitoring data (n.b. use the monitor to show the extracted data)'
    |   +---running-01
    |   |      MasterContent.xml
    |   |
    |   +---running-02
    |   |      MasterContent.xml
    |   |
    |   +---running-03
    |   |      MasterContent.xml
    |   |
    |   +---running-04
    |   |      MasterContent.xml
    |   |
    |   +---running-05
    |   |      MasterContent.xml
    |   |
    |   +---running-06
    |   |      MasterContent.xml
    |   |
    |   \---running-07
    |          MasterContent.xml
    |
    +---retrieve-monitoring-data
    |
    \---syncope 'is the monitor (n.b. read the documentation before using it)'
```

## License
Licensed under the Apache Software License, Version 2.0.
