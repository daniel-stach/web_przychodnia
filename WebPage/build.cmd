@echo off

for %%f in (index, lekarze, kontakt, rejestracja, rejestracja-zakonczona, zaloguj, recepcja, edytuj, nieloguj) do (
	copy /b src\_header.html + src\_menu.html + src\pages\_%%f.html + src\_footer.html out\%%f.html
)
