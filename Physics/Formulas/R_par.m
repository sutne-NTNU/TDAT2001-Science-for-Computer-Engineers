function R_eff = R_par(motstander)
sum = 0;
for i = 1:size(motstander')
	sum = sum + (1 / motstander(1, i));
end
 R_eff = 1/sum;
end

