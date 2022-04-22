function C_eff = C_ser(kondensatorer)
sum = 0;
for i = 1:size(kondensatorer')
	sum = sum + (1 / kondensatorer(1, i));
end
 C_eff = 1/sum;
end

