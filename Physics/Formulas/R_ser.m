function R_eff = R_ser(motstander)
R_eff = 0;
for i = 1:size(motstander')
	R_eff = R_eff + (motstander(1, i));
end
end

