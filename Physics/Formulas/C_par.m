function C_eff = C_par(kondensatorer)
C_eff = 0;
for i = 1:size(kondensatorer')
	C_eff = C_eff + kondensatorer(1, i);
end
end

