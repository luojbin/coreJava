@echo off
echo path:%~dp0
set base=%~dp0

java -cp %base% com.loyofo.core.s7_swing.g1_vstLucky.VstLucky
@pause
