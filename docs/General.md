# General Documentation

## ZenBreeder

### Data Model ZenBreeder

![Data Model Zenbreeder UML](zenbreeder_datamodel_uml.png)

### Class Diagram ZenBreeder

![Class Diagram ZenBreeder](zenbreeder_uml_cd.png)

## ZenLexicon

### Data Model ZenLexicon

![Data Model ZenLexicon UML](zen_lexicon.uml.png)

- CareSheet Table:
  - CareSheetID (Primary Key)
  - Title
  - Description
  - SpeciesID (Foreign Key referencing Species table)
  - CreatedAt
  - UpdatedAt
- CareSheetTexts Table:
  - TextID (Primary Key)
  - CareSheetID (Foreign Key referencing CareSheet table)
  - Text
- CareSheetImages Table:
  - ImageID (Primary Key)
  - CareSheetID (Foreign Key referencing CareSheet table)
  - ImageURL (or binary data)
- Morph Table:
  - MorphID (Primary Key)
  - Name
  - Description
  - MedicalPosition
  - Heterozygous
  - Dominant
  - CoDominant
  - Recessive
  - SuperMorph
- Category Table:
  - CategoryID (Primary Key)
  - Name
  - Description
- Species Table:
  - SpeciesID (Primary Key)
  - Name
  - ScientificName
  - Image (URL or binary data)
  - Description
  - Origin
  - Diet
  - DietType
  - AverageLifespan
  - Behavior
  - Sociability
  - Activity
  - Toxicity
  - TempRange
  - HumidityRange
  - Light
  - Kingdom
  - Phylum
  - Class
  - Order
  - Family
  - Genus
  - CategoryID (Foreign Key referencing Category table)
  - EnclosureID (Foreign Key   - referencing Enclosure table)
  - NoteID (Foreign Key referencing Notes table)
  - MorphID (Foreign Key referencing Morph table)
- Enclosure Table:
  - EnclosureID (Primary Key)
  - Width
  - Depth
  - Height
  - Material
  - Maintenance
  - Substrate
- Notes Table:
  - NoteID (Primary Key)
  - Title
  - Text
  - CreatedAt
  - UpdatedAt
- Conservation Status Table:
  - StatusID (Primary Key)
  - StatusName
  - Description
- SpeciesConservation Table (Many-to-Many Relationship):
  - SpeciesConservationID (Primary Key)
  - SpeciesID (Foreign Key referencing Species table)
  - StatusID (Foreign Key referencing Conservation Status table)
  - CompulsoryRegistration

### Class Diagram ZenLexicon

![Class Diagram ZenLexicon]()

## ZenTank

### Data Model ZenTank

![Class Diagram ZenLexicon]()

### Class Diagram ZenTank

![Class Diagram ZenTank]()
